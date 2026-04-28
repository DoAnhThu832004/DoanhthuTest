package com.example.roadmapaperolesson3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.roadmapaperolesson3.ui.theme.RoadMapAperoLesson3Theme
import com.example.roadmapaperolesson3.view.general.RecipeApp
import com.example.roadmapaperolesson3.viewmodel.MainViewModel
import com.example.roadmapaperolesson3.viewmodel.VideoViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: MainViewModel = hiltViewModel()
            val message by viewModel.uiState.collectAsState()
            val freeCount by viewModel.freeCount.collectAsState()
            val nameUser by viewModel.nameUser.collectAsState()
            val errorMessage by viewModel.errorMessage.collectAsState()
            val videoViewModel: VideoViewModel = hiltViewModel()
            RoadMapAperoLesson3Theme {
//                FreeCountScreen(
//                    count = freeCount,
//                    onIncrementClick = {viewModel.incrementFreeCount()},
//                    onResetClick = {viewModel.resetFreeCount()},
//                    onDecrementClick = {viewModel.decrementFreeCount()}
//                )
//                SaveName(
//                    name = nameUser,
//                    onNameChange = {viewModel.updateUserName(it)},
//                    errorMessage = errorMessage,
//                    onErrorDismiss = {viewModel.clearError()}
//                )
                //CacheVideoScreen()
                //ListFileCache()
                RecipeApp(navController = navController)
            }
        }
    }
}