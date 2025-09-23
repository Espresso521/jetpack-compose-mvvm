package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotaku.mvvm.vm.WordsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    vm: WordsViewModel,
    onOpenDetail: (Int) -> Unit
) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("単語", "お気に入り")

    Scaffold(
        topBar = { TopAppBar(title = { Text("単語帳") }) }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { i, title ->
                    Tab(selected = tabIndex == i, onClick = { tabIndex = i }, text = { Text(title) })
                }
            }
            when (tabIndex) {
                0 -> WordListTab(words = vm.words.collectAsState().value, onClick = { onOpenDetail(it) })
                1 -> FavoritesTab(words = vm.words.collectAsState().value.filter { it.isFavorite }, onClick = { onOpenDetail(it) })
            }
        }
    }
}