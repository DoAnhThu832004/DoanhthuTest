package com.example.roadmapaperolesson3.datasoure.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FileRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun saveVideoToCache(inputStream: InputStream, fileName: String): File {
        val file = File(context.cacheDir, fileName)
        inputStream.use { input ->
            file.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        return file
    }
    fun getCacheFile(fileName: String): File? {
        val file = File(context.cacheDir,fileName)
        return if(file.exists()) file else null
    }
    fun clearCache(fileName: String) {
        File(context.cacheDir,fileName).delete()
    }
    fun getListFileCache(): List<File> {
        return context.cacheDir.listFiles()?.toList() ?: emptyList()
    }
}