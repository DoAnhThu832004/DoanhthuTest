package com.example.roadmapaperolesson3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadmapaperolesson3.datasoure.repository.FileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val fileRepository: FileRepository
): ViewModel() {
    private val _listFileCache = MutableStateFlow<List<File>>(emptyList())
    val listFileCache: StateFlow<List<File>> = _listFileCache.asStateFlow()
    fun cacheVideo(inputStream: InputStream) {
        viewModelScope.launch(Dispatchers.IO) {
            fileRepository.saveVideoToCache(inputStream,"video.mp4")
        }
    }
    fun listFileCache() {
        viewModelScope.launch(Dispatchers.IO) {
            val files = fileRepository.getListFileCache()
            _listFileCache.value = files
        }
    }
}