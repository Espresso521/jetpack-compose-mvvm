package com.kotaku.mvvm.db

import androidx.room.*
import com.kotaku.mvvm.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM words ORDER BY term")
    fun getAll(): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE id = :id")
    fun observeById(id: Int): Flow<Word?>

    @Query("SELECT * FROM words WHERE id = :id")
    suspend fun getById(id: Int): Word?

    @Update
    suspend fun update(word: Word)
}