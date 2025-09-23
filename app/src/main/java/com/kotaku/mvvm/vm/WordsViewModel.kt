package com.kotaku.mvvm.vm

import androidx.lifecycle.ViewModel
import com.kotaku.mvvm.data.WordRepository
import com.kotaku.mvvm.model.Word
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class WordsViewModel(
    private val repo: WordRepository = WordRepository()
) : ViewModel() {

    private val _words = MutableStateFlow(repo.loadAll())
    val words: StateFlow<List<Word>> = _words

    fun toggleFavorite(id: Int) {
        _words.update { list ->
            list.map { w -> if (w.id == id) w.copy(isFavorite = !w.isFavorite) else w }
        }
    }

    fun getById(id: Int): Word? = _words.value.firstOrNull { it.id == id }

    val favorites: StateFlow<List<Word>> get() =
        MutableStateFlow(_words.value.filter { it.isFavorite })
            .also { flow ->
                // 简单方式：每次读时刷新（小项目OK；正式项目建议用 combine/map）
                flow.value = _words.value.filter { it.isFavorite }
            }
}