package com.example.impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.impl.db.dao.DaoItems
import com.example.impl.db.entity.ItemEntity


@Database(
    entities = [ItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDbRoom : RoomDatabase() {
    abstract fun daoItems(): DaoItems
}