package com.example.api

import com.example.models.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getAllItems(): Flow<List<Item>>
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(item: Item)
}