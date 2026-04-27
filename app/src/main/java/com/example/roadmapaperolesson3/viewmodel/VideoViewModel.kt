package com.example.roadmapaperolesson3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadmapaperolesson3.datasoure.repository.FileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val fileRepository: FileRepository
): ViewModel() {
    fun cacheVideo(inputStream: InputStream) {
        viewModelScope.launch(Dispatchers.IO) {
            fileRepository.saveVideoToCache(inputStream,"video.mp4")
        }
    }
}