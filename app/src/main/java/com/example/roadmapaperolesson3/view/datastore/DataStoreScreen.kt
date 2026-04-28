package com.example.roadmapaperolesson3.view.datastore

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
fun DataStoreScreen(
    onNavigateToSaveName: () -> Unit = {},
    onNavigateToFreeCount: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {onNavigateToSaveName()}
        ) {
            Text(
                text = "Save Name Screen",
            )
        }
        Button(
            onClick = {onNavigateToFreeCount()}
        ) {
            Text(
                text = "Free Count Screen"
            )
        }
    }
}