package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kotaku.mvvm.model.Word

@Composable
fun FavoritesTab(words: List<Word>, onClick: (Int) -> Unit) {
    if (words.isEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            Text("お気に入りはまだありません")
        }
    } else {
        WordListTab(words = words, onClick = onClick)
    }
}