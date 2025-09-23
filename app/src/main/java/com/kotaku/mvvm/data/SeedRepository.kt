package com.kotaku.mvvm.data

import com.kotaku.mvvm.db.WordDao
import com.kotaku.mvvm.di.IoDispatcher
import com.kotaku.mvvm.ui.icons.IconCatalog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeedRepository @Inject constructor(
    private val dao: WordDao,
    @IoDispatcher private val io: CoroutineDispatcher,
    private val scope: CoroutineScope
) {
    fun seedIfEmpty() = scope.launch(io) {
        if (dao.count() == 0) dao.insertAll(IconCatalog.SEED)
    }
}