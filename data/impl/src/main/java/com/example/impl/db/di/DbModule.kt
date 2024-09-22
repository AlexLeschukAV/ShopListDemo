package com.example.data.impl.db.di

import android.content.Context
import androidx.room.Room
import com.example.impl.db.AppDbRoom
import com.example.impl.db.dao.DaoItems
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext
        appContext: Context,
    ): AppDbRoom {
        return Room.databaseBuilder(
            context = appContext,
            klass = AppDbRoom::class.java,
            name = BD_NAME
        ).createFromAsset("demo_data.db").build()
    }

    @Provides
    fun provideDaoAffirmations(
        database: AppDbRoom,
    ): DaoItems {
        return database.daoItems()
    }

    private const val BD_NAME = "demo_database"
}