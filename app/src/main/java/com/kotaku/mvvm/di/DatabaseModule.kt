package com.kotaku.mvvm.di

import android.app.Application
import androidx.room.Room
import com.kotaku.mvvm.db.AppDatabase
import com.kotaku.mvvm.db.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "words.db").build()

    @Provides
    fun provideWordDao(db: AppDatabase): WordDao = db.wordDao()
}