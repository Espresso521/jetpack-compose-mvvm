package com.kotaku.mvvm.data

import com.kotaku.mvvm.model.Word

class WordRepository {
    private val seed = listOf(
        Word(1, "abandon", "放弃；遗弃", "He abandoned his plan."),
        Word(2, "benevolent", "仁慈的；乐善好施的", "A benevolent smile."),
        Word(3, "concise", "简洁的；简明的", "A concise summary."),
        Word(4, "diligent", "勤奋的；用功的", "A diligent student."),
        Word(5, "elaborate", "精心制作的；详尽的", "An elaborate design.")
    )

    fun loadAll(): List<Word> = seed
}