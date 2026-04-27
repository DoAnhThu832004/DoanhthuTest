package com.example.roadmapaperolesson3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roadmapaperolesson3.ui.theme.RoadMapAperoLesson3Theme
import com.example.roadmapaperolesson3.view.FreeCountScreen
import com.example.roadmapaperolesson3.view.SaveName
import com.example.roadmapaperolesson3.viewmodel.MainViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            val message by viewModel.uiState.collectAsState()
            val freeCount by viewModel.freeCount.collectAsState()
            val nameUser by viewModel.nameUser.collectAsState()
            val errorMessage by viewModel.errorMessage.collectAsState()
            RoadMapAperoLesson3Theme {
//                FreeCountScreen(
//                    count = freeCount,
//                    onIncrementClick = {viewModel.incrementFreeCount()},
//                    onResetClick = {viewModel.resetFreeCount()},
//                    onDecrementClick = {viewModel.decrementFreeCount()}
//                )
                SaveName(
                    name = nameUser,
                    onNameChange = {viewModel.updateUserName(it)},
                    errorMessage = errorMessage,
                    onErrorDismiss = {viewModel.clearError()}
                )
            }
        }
    }
}