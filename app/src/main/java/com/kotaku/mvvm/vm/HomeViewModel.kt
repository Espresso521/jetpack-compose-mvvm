package com.kotaku.mvvm.vm

import androidx.lifecycle.ViewModel
import com.kotaku.mvvm.data.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

// HomeViewModel.kt
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val session: SessionManager
) : ViewModel() {

    // UI 一次性事件（登出后通知 UI 导航）
    sealed interface Event {
        data object Logout : Event
    }

    private val _events = MutableSharedFlow<Event>(extraBufferCapacity = 1)
    val events: SharedFlow<Event> = _events

    fun logout() {
        session.setLoggedIn(false)
        _events.tryEmit(Event.Logout)
    }
}