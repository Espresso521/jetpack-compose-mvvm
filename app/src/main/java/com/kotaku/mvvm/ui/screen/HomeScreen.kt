package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
    onLogout: () -> Unit,              // 新增：登出回调
    iconsOnly: Boolean = false         // 可选：只显示图标（true）或图标+文字（false）
) {
    var selected by remember { mutableStateOf(0) }

    val allWords = wordsVm.words.collectAsState().value
    val favWords = remember(allWords) { allWords.filter { it.isFavorite } }

    val items = listOf(
        NavItem("単語", Icons.Filled.List),
        NavItem("お気に入り", Icons.Filled.Favorite)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("単語帳") },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, it ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = { Icon(it.icon, contentDescription = it.label) },
                        label = if (iconsOnly) null else ({ Text(it.label) }),
                        alwaysShowLabel = !iconsOnly
                    )
                }
            }
        }
    ) { inner ->
        Box(Modifier.padding(inner)) {
            when (selected) {
                0 -> WordListTab(words = allWords, onClick = onOpenDetail)
                1 -> WordListTab(words = favWords, onClick = onOpenDetail)
            }
        }
    }
}

private data class NavItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)