package com.example.shoplistdemo.di


import com.example.api.DeleteItemUseCase
import com.example.api.GetItemsUseCase
import com.example.api.ItemRepository
import com.example.api.UpdateItemUseCase
import com.example.impl.repository.ItemRepositoryImpl
import com.example.impl.usecase.DeleteItemUseCaseImpl
import com.example.impl.usecase.GetItemsUseCaseImpl
import com.example.impl.usecase.UpdateItemUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindsModule {

    @Binds
    fun bindGetItemsUseCase(impl: GetItemsUseCaseImpl): GetItemsUseCase

    @Binds
    fun bindUpdateItemUseCase(impl: UpdateItemUseCaseImpl): UpdateItemUseCase

    @Binds
    fun bindDeleteItemUseCase(impl: DeleteItemUseCaseImpl): DeleteItemUseCase

    @Binds
    fun bindItemRepositoryImpl(impl: ItemRepositoryImpl): ItemRepository
}