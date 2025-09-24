package com.kotaku.mvvm.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.kotaku.mvvm.model.Word

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WordDetailPagerScreen(
    words: List<Word>,
    initialWordId: Int,
    onBack: () -> Unit,
    onToggleFavorite: (Int) -> Unit,
    // 传入一个把 Word 映射到媒体(可为 null)的函数，便于你走 wordIconMap
    mediaFor: (Word) -> DetailMedia? = { null },
    modifier: Modifier = Modifier
) {
    if (words.isEmpty()) {
        // 没数据就直接返回
        return
    }

    val initialPage = remember(words, initialWordId) {
        words.indexOfFirst { it.id == initialWordId }.coerceAtLeast(0)
    }

    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { words.size }
    )

    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        val w = words[page]
        DetailScreen(
            word = w,
            onBack = onBack,
            onToggleFavorite = { onToggleFavorite(w.id) },
            media = mediaFor(w) // 根据当前单词提供 Rive / Image
        )
    }
}