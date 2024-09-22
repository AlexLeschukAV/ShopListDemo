package com.example.impl.repository

import com.example.api.ItemRepository
import com.example.impl.db.dao.DaoItems
import com.example.impl.db.toEntity
import com.example.impl.db.toModel
import com.example.models.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: DaoItems,
) : ItemRepository {

    override fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAll().map { listEntity ->
            listEntity.map { it.toModel() }
        }
    }

    override suspend fun updateItem(item: Item) {
        itemDao.update(item.toEntity())
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.delete(item.toEntity())
    }
}