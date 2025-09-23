package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kotaku.mvvm.model.Word

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
        ) { Text("単語が見つかりません") }
        return
    }

    val scroll = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(word.term) }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onToggleFavorite,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = if (word.isFavorite) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                text = { Text(if (word.isFavorite) "お気に入り解除" else "お気に入り") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .verticalScroll(scroll)
                .fillMaxWidth()
        ) {
            // Term
            Text(
                text = word.term,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(Modifier.height(8.dp))
            Divider()
            Spacer(Modifier.height(12.dp))

            // Meaning
            Text(
                text = "意味",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = word.meaning,
                style = MaterialTheme.typography.bodyLarge
            )

            // Examples
            val hasEn = word.exampleEn.isNotBlank()
            val hasJa = word.exampleJa.isNotBlank()
            if (hasEn || hasJa) {
                Spacer(Modifier.height(16.dp))
                Divider()
                Spacer(Modifier.height(12.dp))

                Text(
                    text = "例文",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(6.dp))

                if (hasEn) {
                    Text(
                        text = "EN：${word.exampleEn}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(Modifier.height(8.dp))
                }
                if (hasJa) {
                    Text(
                        text = "JA：${word.exampleJa}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(Modifier.height(96.dp)) // 给 FAB 留出空间，避免遮挡
        }
    }
}