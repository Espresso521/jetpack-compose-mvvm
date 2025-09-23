package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotaku.mvvm.model.Word
import timber.log.Timber

@Composable
fun WordListTab(
    words: List<Word>,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        Timber.d("WordListTab:: words size = ${words.size}")
        items(words, key = { it.id }) { w ->
            ListItem(
                headlineContent = { Text(w.term) },
                supportingContent = { Text(w.meaning) },
                trailingContent = {
                    if (w.isFavorite) Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(w.id) }
                    .padding(horizontal = 8.dp)
            )
            Divider()
        }
    }
}