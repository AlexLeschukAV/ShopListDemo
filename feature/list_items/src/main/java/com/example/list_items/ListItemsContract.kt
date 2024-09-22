package com.example.list_items

import com.example.models.Item


object ListItemsContract {

    sealed interface Event {
        data class OnClickEdit(val item: Item) : Event
        data class OnClickDelete(val item: Item) : Event
        data class OnChangeItem(val item: Item) : Event
        data class OnDeleteItem(val item: Item) : Event
    }

    data class State(
        val listItems: List<Item>? = null,
    )

    sealed interface Effect {
        data class ToEditDialog(val item: Item) : Effect
        data class ToDeleteDialog(val item: Item) : Effect
    }
}