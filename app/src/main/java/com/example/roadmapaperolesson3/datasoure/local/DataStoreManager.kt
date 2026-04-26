package com.example.roadmapaperolesson3.datasoure.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore by preferencesDataStore("app_prefs")
    private val Free_COUNT = intPreferencesKey("free_count")

    val freeCountFlow = context.dataStore.data
        .map { it[Free_COUNT]?: 0 }
    suspend fun setFreeCount(value: Int) {
        context.dataStore.edit {
            it[Free_COUNT] = value
        }
    }
}