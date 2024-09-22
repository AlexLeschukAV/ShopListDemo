package com.example.impl.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.impl.db.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoItems {

    @Query("SELECT * FROM item")
    fun getAll(): Flow<List<ItemEntity>>

    @Update
    suspend fun update(entity: ItemEntity)

    @Delete
    suspend fun delete(entity: ItemEntity)
}