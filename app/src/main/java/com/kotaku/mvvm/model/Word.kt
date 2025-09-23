package com.kotaku.mvvm.model

data class Word(
    val id: Int,
    val term: String,
    val meaning: String,
    val example: String = "",
    val isFavorite: Boolean = false
)