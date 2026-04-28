package com.example.roadmapaperolesson3.view.InternalStorage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InternalStorageScreen(
    onNavigateToCacheVideo: () -> Unit = {},
    onNavigateToListFileCache: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {onNavigateToCacheVideo()}
        ) {
            Text(
                text = "Cache Video Screen",
            )
        }
        Button(
            onClick = {onNavigateToListFileCache()}
        ) {
            Text(
                text = "List File Cache",
            )
        }
    }
}