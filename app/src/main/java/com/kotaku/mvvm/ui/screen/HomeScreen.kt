package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kotaku.mvvm.vm.WordsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    wordsVm: WordsViewModel,
    onOpenDetail: (Int) -> Unit,
    onLogout: () -> Unit,
    iconsOnly: Boolean
) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("単語", "お気に入り")
    val systemUiController = rememberSystemUiController()

    var showLogoutDialog by remember { mutableStateOf(false) }

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFF4483D1),
            darkIcons = false
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("単語帳", color = Color.White) },
                actions = {
                    IconButton(onClick = { showLogoutDialog = true }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4483D1), // 蓝色背景
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF4483D1) // 底栏背景白
            ) {
                tabs.forEachIndexed { i, title ->
                    NavigationBarItem(
                        selected = tabIndex == i,
                        onClick = { tabIndex = i },
                        icon = {
                            val iconColor =
                                if (tabIndex == i) Color.White else Color(0xFFBBDEFB)
                            if (iconsOnly) {
                                if (i == 0) Icon(
                                    Icons.AutoMirrored.Filled.List,
                                    null,
                                    tint = iconColor
                                )
                                else Icon(Icons.Default.Favorite, null, tint = iconColor)
                            } else {
                                Icon(
                                    if (i == 0) Icons.AutoMirrored.Filled.List else Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = iconColor
                                )
                            }
                        },
                        label = if (iconsOnly) null else {
                            {
                                Text(
                                    title,
                                    color = if (tabIndex == i) Color.White else Color(0xFFBBDEFB),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color(0xFFBBDEFB),
                            selectedTextColor = Color.White,
                            unselectedTextColor = Color(0xFFBBDEFB),
                            indicatorColor = Color(0xFF64B5F6) // ← 调整选中背景色（淡蓝、柔和）
                        )
                    )
                }
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            when (tabIndex) {
                0 -> WordListTab(
                    words = wordsVm.words.collectAsState().value,
                    onClick = { onOpenDetail(it) })

                1 -> FavoritesTab(
                    words = wordsVm.words.collectAsState().value.filter { it.isFavorite },
                    onClick = { onOpenDetail(it) })
            }
        }
    }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("ログアウト確認") },
            text = { Text("本当にログアウトしますか？") },
            confirmButton = {
                TextButton(onClick = {
                    showLogoutDialog = false
                    onLogout()
                }) {
                    Text("はい")
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text("キャンセル")
                }
            }
        )
    }
}