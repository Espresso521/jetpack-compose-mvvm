package com.kotaku.mvvm.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kotaku.mvvm.model.Word
import com.kotaku.mvvm.ui.ComposableRiveAnimationView

sealed class DetailMedia {
    data class Rive(@RawRes val resId: Int) : DetailMedia()
    data class Image(@DrawableRes val resId: Int) : DetailMedia()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    word: Word?,
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    media: DetailMedia? = null
) {
    if (word == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("単語が見つかりません")
        }
        return
    }

    val scroll = rememberScrollState()
    val cs = MaterialTheme.colorScheme
    val topBarColor = Color(0xFF4483D1)

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "戻る",
                            tint = cs.onPrimary
                        )
                    }
                },
                title = { Text(word.term, color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = topBarColor
                )
            )
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
                text = { Text(if (word.isFavorite) "お気に入り解除" else "お気に入り") },
                containerColor = Color(0xFF4483D1),         // FAB 改为蓝色
                contentColor = cs.onPrimary,         // 文字/图标颜色
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 6.dp, pressedElevation = 8.dp
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scroll)
        ) {
            // ===== 媒体区：用卡片区分背景 =====
            if (media != null) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = cs.secondaryContainer
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.large
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        when (media) {
                            is DetailMedia.Rive -> {
                                ComposableRiveAnimationView(
                                    animation = media.resId,
                                    modifier = Modifier.fillMaxSize()
                                ) { }
                            }

                            is DetailMedia.Image -> {
                                Image(
                                    painter = painterResource(media.resId),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }

            // ===== 详情区：保持原样，但与上方色块形成对比 =====
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = word.term,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.height(8.dp))
                Divider()
                Spacer(Modifier.height(12.dp))

                Text(
                    text = "意味",
                    style = MaterialTheme.typography.titleSmall,
                    color = cs.primary
                )
                Spacer(Modifier.height(6.dp))
                Text(text = word.meaning, style = MaterialTheme.typography.bodyLarge)

                val hasEn = word.exampleEn.isNotBlank()
                val hasJa = word.exampleJa.isNotBlank()
                if (hasEn || hasJa) {
                    Spacer(Modifier.height(16.dp))
                    Divider()
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "例文",
                        style = MaterialTheme.typography.titleSmall,
                        color = cs.primary
                    )
                    Spacer(Modifier.height(6.dp))
                    if (hasEn) {
                        Text("EN：${word.exampleEn}", style = MaterialTheme.typography.bodyLarge)
                        Spacer(Modifier.height(8.dp))
                    }
                    if (hasJa) {
                        Text("JA：${word.exampleJa}", style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(Modifier.height(96.dp))
            }
        }
    }
}