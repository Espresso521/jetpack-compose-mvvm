package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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

    // 控制对话框显示
    var showLogoutDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("単語帳") },
                actions = {
                    IconButton(onClick = { showLogoutDialog = true }) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { i, title ->
                    NavigationBarItem(
                        selected = tabIndex == i,
                        onClick = { tabIndex = i },
                        icon = {
                            if (iconsOnly) {
                                if (i == 0) Icon(Icons.Default.List, null)
                                else Icon(Icons.Default.Favorite, null)
                            } else {
                                Icon(
                                    if (i == 0) Icons.Default.List else Icons.Default.Favorite,
                                    contentDescription = null
                                )
                            }
                        },
                        label = if (iconsOnly) null else {
                            { Text(title) }
                        }
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

    // 登出确认对话框
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

private data class NavItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)