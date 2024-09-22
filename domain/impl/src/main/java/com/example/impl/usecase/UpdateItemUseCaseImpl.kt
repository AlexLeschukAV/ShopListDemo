package com.example.impl.usecase


import com.example.api.UpdateItemUseCase
import com.example.api.ItemRepository
import com.example.models.Item
import javax.inject.Inject

class UpdateItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository,
) : UpdateItemUseCase {

    override suspend fun invoke(item: Item) {
        return itemRepository.updateItem(item)
    }
}