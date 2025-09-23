package com.kotaku.mvvm.vm

import androidx.lifecycle.ViewModel
import com.kotaku.mvvm.data.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

// vm/SplashViewModel.kt
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val session: SessionManager
) : ViewModel() {
    fun decideLoggedIn(): Boolean = session.isLoggedIn()
}