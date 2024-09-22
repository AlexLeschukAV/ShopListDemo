package com.example.api

import com.example.models.Item

interface DeleteItemUseCase {

    suspend operator fun invoke(item: Item)
}