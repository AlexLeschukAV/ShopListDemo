package com.example.impl.usecase


import com.example.api.DeleteItemUseCase
import com.example.api.ItemRepository
import com.example.models.Item


import javax.inject.Inject

class DeleteItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository,
) : DeleteItemUseCase {

    override suspend fun invoke(item: Item) {
        return itemRepository.deleteItem(item)
    }
}