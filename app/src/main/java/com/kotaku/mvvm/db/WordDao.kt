package com.kotaku.mvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(words: List<Word>)

    @Query("SELECT COUNT(*) FROM words")
    suspend fun count(): Int
}