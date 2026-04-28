package com.example.roadmapaperolesson3.view.general

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SelectApp(
    onNavigateToDataStore: () -> Unit = {},
    onNavigateToInternalStorage: () -> Unit = {},
    onNavigateToExternalStorage: () -> Unit = {},
    onNavigateToCache: () -> Unit = {},
    onNavigateToMediaStore: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {onNavigateToDataStore()}
        ) {
            Text(
                text = "DataStore",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Button(
            onClick = {onNavigateToInternalStorage()}
        ) {
            Text(
                text = "Internal Storage (bộ nhớ trong app)",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Button(
            onClick = {}
        ) {
            Text(
                text = "External Storage (bộ nhớ ngoài)",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Button(
            onClick = {}
        ) {
            Text(
                text = "Cache",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Button(
            onClick = {}
        ) {
            Text(
                text = "MediaStore",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}