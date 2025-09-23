package com.kotaku.mvvm.ui.screen

import androidx.compose.runtime.*

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    LoginUI(onLoginSuccess)
}