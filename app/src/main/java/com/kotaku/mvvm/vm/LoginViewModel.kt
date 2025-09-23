package com.kotaku.mvvm.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotaku.mvvm.data.SessionManager
import com.kotaku.mvvm.di.MainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    @MainDispatcher private val main: CoroutineDispatcher,
    private val session: SessionManager
) : ViewModel() {

    // 一次性导航事件：用 SharedFlow 比 LiveData 更适合 one-shot 事件
    private val _navigateToHome = MutableSharedFlow<Unit>(replay = 0)
    val navigateToHome: SharedFlow<Unit> = _navigateToHome

    fun onLoginSuccess() {
        session.setLoggedIn(true)
        triggerSuccessWithDelay()
    }

    fun logout() {
        session.clear()
    }

    fun triggerSuccessWithDelay() {
        viewModelScope.launch(main) {
            delay(2000)
            _navigateToHome.emit(Unit)
        }
    }
}