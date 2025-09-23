package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotaku.mvvm.model.Word
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    word: Word?,
    onToggleFavorite: () -> Unit
) {
    if (word == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("単語が見つかりません")
        }
        return
    }

    Scaffold(
        topBar = {
            // 若 TopAppBar 不可用，用 CenterAlignedTopAppBar
            TopAppBar(title = { Text(word.term) })
            // CenterAlignedTopAppBar(title = { Text(word.term) })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onToggleFavorite,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null
                    )
                },
                text = {
                    Text(if (word.isFavorite) "お気に入り解除" else "お気に入り")
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "意味：${word.meaning}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(12.dp))
            if (word.example.isNotBlank()) {
                Text(text = "例文：${word.example}")
            }
        }
    }
}