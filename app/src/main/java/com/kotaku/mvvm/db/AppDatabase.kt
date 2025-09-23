package com.kotaku.mvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kotaku.mvvm.model.Word

@Database(entities = [Word::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}