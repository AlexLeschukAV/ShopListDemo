package com.example.impl.db

import com.example.impl.db.entity.ItemEntity
import com.example.models.Item


fun ItemEntity.toModel() = Item(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount,
)

fun Item.toEntity() = ItemEntity(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount,
)