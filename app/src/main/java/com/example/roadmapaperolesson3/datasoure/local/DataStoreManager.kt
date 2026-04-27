package com.example.roadmapaperolesson3.datasoure.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.Navigator
import com.example.roadmapaperolesson3.extensions.catchIOException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore by preferencesDataStore("app_prefs")
    private val Free_COUNT = intPreferencesKey("free_count")
    private val NAME_USER = stringPreferencesKey("name_user")
    val freeCountFlow = context.dataStore.data
        .catchIOException()
        .map { it[Free_COUNT]?: 0 }
    val nameUserFlow = context.dataStore.data
        .catchIOException()
        .map { it[NAME_USER]?: "Do Anh Thu" }
    suspend fun setFreeCount(value: Int): Result<Unit> {
        return try {
            context.dataStore.edit {
                it[Free_COUNT] = value
            }
            Result.success(Unit)
        } catch (e: IOException) {
            Result.failure(e)
        }
    }
    suspend fun setNameUser(value: String): Result<Unit> {
        return try {
            context.dataStore.edit {
                it[NAME_USER] = value
            }
            Result.success(Unit)
        } catch (e: IOException) {
            Result.failure(e)
        }
    }
}