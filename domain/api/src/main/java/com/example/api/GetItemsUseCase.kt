package com.example.api

import com.example.models.Item
import kotlinx.coroutines.flow.Flow

interface GetItemsUseCase {

    operator fun invoke(): Flow<List<Item>>
}