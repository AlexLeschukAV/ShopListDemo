package com.example.impl.usecase


import com.example.api.GetItemsUseCase
import com.example.api.ItemRepository
import com.example.models.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository,
) : GetItemsUseCase {

    override fun invoke(): Flow<List<Item>> {
       return itemRepository.getAllItems()
    }
}