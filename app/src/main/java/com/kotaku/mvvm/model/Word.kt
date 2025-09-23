package com.kotaku.mvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val term: String,
    val meaning: String,
    val exampleEn: String,
    val exampleJa: String,
    val isFavorite: Boolean = false
)