package com.kotaku.mvvm.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotaku.mvvm.db.WordDao
import com.kotaku.mvvm.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class WordsViewModel @Inject constructor(
    private val dao: WordDao
) : ViewModel() {

    val words = dao.getAll().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    /** Detail 用：按 id 观察单条 */
    fun wordFlow(id: Int) = dao.observeById(id)

    /** Detail 用：按 id 切换收藏 */
    fun toggleFavorite(id: Int) = viewModelScope.launch {
        dao.getById(id)?.let { current ->
            dao.update(current.copy(isFavorite = !current.isFavorite))
        }
    }

    /** 如果你仍想保留原版 */
    fun toggleFavorite(word: Word) = viewModelScope.launch {
        dao.update(word.copy(isFavorite = !word.isFavorite))
    }
}