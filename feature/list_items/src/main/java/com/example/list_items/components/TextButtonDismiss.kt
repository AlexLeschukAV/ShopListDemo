package com.example.list_items.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.list_items.R

@Composable
fun TextButtonDismiss(onDismissRequest: () -> Unit) {
    TextButton(onClick = onDismissRequest) {
        Text(
            text = stringResource(R.string.text_cancel),
            color = IconsDialogColor,
        )
    }
}