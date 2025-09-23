package com.kotaku.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kotaku.mvvm.ui.AppNav
import com.kotaku.mvvm.vm.WordsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = WordsViewModel()
        setContent {
            AppNav(vm = vm)
        }
    }
}