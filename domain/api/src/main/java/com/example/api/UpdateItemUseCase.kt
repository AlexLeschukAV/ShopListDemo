package com.example.api

import com.example.models.Item

interface UpdateItemUseCase {

   suspend operator fun invoke(item: Item)
}