package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kotaku.mvvm.model.Word
import com.kotaku.mvvm.ui.icons.IconCatalog
import kotlin.math.absoluteValue

@Composable
fun WordListTab(
    words: List<Word>,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(words, key = { it.id }) { w ->
            WordRow(
                word = w,
                onClick = { onClick(w.id) }
            )
            Divider(
                modifier = Modifier.padding(start = 72.dp), // 与头像对齐，视觉更干净
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.06f),
                thickness = 0.5.dp
            )
        }
    }
}

@Composable
private fun WordRow(
    word: Word,
    onClick: () -> Unit
) {
    val headline = word.term
    val subtitle = word.meaning

    ListItem(
        leadingContent = {
            val icon = IconCatalog.wordMediaMap[headline.lowercase()]
            if (icon != null) {
                // 如果有对应 Icon
                Icon(
                    imageVector = icon.listIcon,
                    contentDescription = headline,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
            } else {
                // fallback → 首字母圆形头像
                val bg = avatarColorFor(headline)
                Surface(
                    color = bg.copy(alpha = 0.18f),
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.size(44.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = headline.take(1).uppercase(),
                            style = MaterialTheme.typography.titleMedium,
                            color = bg
                        )
                    }
                }
            }
        },
        headlineContent = {
            Text(
                headline,
                style = MaterialTheme.typography.titleMedium
            )
        },
        supportingContent = {
            Text(
                subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        },
        trailingContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (word.isFavorite) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.width(8.dp))
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.35f)
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    )
}

@Composable
private fun avatarColorFor(key: String): Color {
    val palette = listOf(
        Color(0xFF4F86E3), // 蓝
        Color(0xFF2BB3B1), // 青
        Color(0xFF8E7AE6), // 紫
        Color(0xFFFFB74D), // 橙
        Color(0xFF66BB6A)  // 绿
    )
    val idx = (key.hashCode().absoluteValue % palette.size)
    return palette[idx]
}