package com.example.roadmapaperolesson3.view.InternalStorage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roadmapaperolesson3.viewmodel.VideoViewModel

@Composable
fun ListFileCache(
    videoViewModel: VideoViewModel = hiltViewModel()
) {
    val listFile by videoViewModel.listFileCache.collectAsState()
    LaunchedEffect(Unit) {
        videoViewModel.listFileCache()
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        item {
            Text(
                text = "List file cache"
            )
        }
        items(
            listFile,
            key = {it.name}
        ) {
            Text(
                text = it.name
            )
        }
    }
}