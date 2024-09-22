package com.example.list_items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import com.example.list_items.ListItemsContract.Effect
import com.example.list_items.ListItemsContract.Event
import com.example.list_items.ListItemsContract.State
import com.example.list_items.components.DialogDelete
import com.example.list_items.components.DialogEdit
import com.example.list_items.components.FindField
import com.example.list_items.components.ItemCard
import com.example.list_items.components.Toolbar
import com.example.list_items.components.VerticalSpacer
import com.example.models.Item

@Composable
fun ListItemsScreen() {
    val viewModel: ListItemsViewModel = hiltViewModel()
    val state: State by viewModel.state.collectAsState()
    val searchText = remember { mutableStateOf(TextFieldValue("")) }
    var showDialogEdit by remember { mutableStateOf(false) }
    var showDialogDelete by remember { mutableStateOf(false) }
    var currentEditItem by remember { mutableStateOf<Item?>(null) }

    viewModel.effect.collectInLaunchedEffect { effect ->
        when (effect) {
            is Effect.ToDeleteDialog -> {
                currentEditItem = effect.item
                showDialogDelete = true
            }

            is Effect.ToEditDialog -> {
                currentEditItem = effect.item
                showDialogEdit = true
            }
        }
    }

    Scaffold(
        topBar = { Toolbar(stringResource(R.string.text_app_bar)) }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            VerticalSpacer(8.dp)
            FindField(
                textInField = searchText.value,
                onChangeText = { searchText.value = it },
                onClickClose = { searchText.value = TextFieldValue("") }
            )
            state.listItems?.let { list ->
                val filteredItemList = list.filter {
                    it.name.lowercase().contains(searchText.value.text.lowercase())
                }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    filteredItemList.forEach { item ->
                        item {
                            VerticalSpacer(20.dp)
                            ItemCard(
                                item = item,
                                onClickEdit = { viewModel.sendEvent { Event.OnClickEdit(item) } },
                                onCLickDelete = { viewModel.sendEvent { Event.OnClickDelete(item) } },
                            )
                        }
                    }
                    item { VerticalSpacer(20.dp) }
                }
            }
        }
        currentEditItem?.let { editableItem ->
            if (showDialogEdit) {
                DialogEdit(
                    amount = editableItem.amount,
                    onApproveRequest = { newAmount ->
                        viewModel.sendEvent { Event.OnChangeItem(editableItem.copy(amount = newAmount)) }
                        currentEditItem = null
                        showDialogEdit = false
                    },
                    onDismissRequest = { showDialogEdit = false }
                )
            }
            if (showDialogDelete) {
                DialogDelete(
                    item = editableItem,
                    onApproveRequest = { item ->
                        viewModel.sendEvent { Event.OnDeleteItem(item) }
                        currentEditItem = null
                        showDialogDelete = false
                    },
                    onDismissRequest = { showDialogDelete = false }
                )
            }
        }
    }
}

@Suppress("ComposableNaming")
@Composable
fun <T> Flow<T>.collectInLaunchedEffect(function: suspend (value: T) -> Unit) {
    val flow = this
    LaunchedEffect(key1 = flow) {
        flow.collectLatest(function)
    }
}