package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kotaku.mvvm.R
import com.kotaku.mvvm.ui.ComposableRiveAnimationView
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: (Boolean) -> Unit) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFFA8E6CF),
            darkIcons = false
        )
    }

    LaunchedEffect(Unit) {
        delay(3000)
        onFinished(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        ComposableRiveAnimationView(
            animation = R.raw.big_ben_english,
            modifier = Modifier.fillMaxHeight(),
            alignment = app.rive.runtime.kotlin.core.Alignment.TOP_CENTER,
        ) { view ->
        }
    }
}