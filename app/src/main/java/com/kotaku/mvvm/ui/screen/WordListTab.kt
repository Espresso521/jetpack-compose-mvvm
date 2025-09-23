package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kotaku.mvvm.model.Word

@Composable
fun WordListTab(words: List<Word>, onClick: (Int) -> Unit) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(words) { w ->
            ListItem(
                headlineContent = { Text(w.term) },
                supportingContent = { Text(w.meaning) },
                modifier = Modifier.clickable { onClick(w.id) }
            )
            Divider()
        }
    }
}