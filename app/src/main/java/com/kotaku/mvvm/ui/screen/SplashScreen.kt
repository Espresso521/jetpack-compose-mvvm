package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: (Boolean) -> Unit) {
    LaunchedEffect(Unit) {
        delay(1200)
        onFinished(false) // demo：假装未登录；实际可读本地登录态
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Vocab", style = MaterialTheme.typography.headlineLarge)
            Spacer(Modifier.height(8.dp))
            CircularProgressIndicator()
        }
    }
}