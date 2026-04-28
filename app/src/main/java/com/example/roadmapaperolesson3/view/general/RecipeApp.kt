package com.example.roadmapaperolesson3.view.general

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.roadmapaperolesson3.view.InternalStorage.CacheVideoScreen
import com.example.roadmapaperolesson3.view.InternalStorage.InternalStorageScreen
import com.example.roadmapaperolesson3.view.InternalStorage.ListFileCache
import com.example.roadmapaperolesson3.view.datastore.FreeCountScreen
import com.example.roadmapaperolesson3.view.datastore.SaveName
import com.example.roadmapaperolesson3.view.datastore.DataStoreScreen
import com.example.roadmapaperolesson3.viewmodel.MainViewModel
import com.example.roadmapaperolesson3.viewmodel.VideoViewModel

@Composable
fun RecipeApp(
    navController: NavHostController
) {
    val mainViewModel: MainViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.SelectApp.route,
    ) {
        composable(Screen.SelectApp.route) {
            SelectApp(
                onNavigateToDataStore = {
                    navController.navigate(Screen.DataStoreScreen.route)
                },
                onNavigateToInternalStorage = {
                    navController.navigate(Screen.InternalStorageScreen.route)
                }
            )
        }
        composable(Screen.DataStoreScreen.route) {
            DataStoreScreen(
                onNavigateToSaveName = {
                    navController.navigate(Screen.SaveNameScreen.route)
                },
                onNavigateToFreeCount = {
                    navController.navigate(Screen.FreeCountScreen.route)
                }
            )
        }
        composable(Screen.SaveNameScreen.route) {
            val name by mainViewModel.nameUser.collectAsState()
            val errorMessage by mainViewModel.errorMessage.collectAsState()
            SaveName(
                name = name,
                onNameChange = {mainViewModel.updateUserName(it)},
                errorMessage = errorMessage,
                onErrorDismiss = {mainViewModel.clearError()}
            )
        }
        composable(Screen.FreeCountScreen.route) {
            val count by mainViewModel.freeCount.collectAsState()
            val errorMessage by mainViewModel.errorMessage.collectAsState()
            FreeCountScreen(
                count = count,
                onIncrementClick = {mainViewModel.incrementFreeCount()},
                onResetClick = {mainViewModel.resetFreeCount()},
                onDecrementClick = {mainViewModel.decrementFreeCount()},
                errorMessage = errorMessage,
                onErrorDismiss = {mainViewModel.clearError()}
            )
        }
        navigation(
            startDestination = Screen.InternalStorageScreen.route,
            route = Graph.InternalStorage
        ) {
            composable(Screen.InternalStorageScreen.route) {
                InternalStorageScreen(
                    onNavigateToCacheVideo = {
                        navController.navigate(Screen.CacheVideoScreen.route)
                    },
                    onNavigateToListFileCache = {
                        navController.navigate(Screen.ListFileCache.route)
                    }
                )
            }
            composable(Screen.CacheVideoScreen.route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Graph.InternalStorage)
                }
                val videoViewModel: VideoViewModel = hiltViewModel(parentEntry)
                CacheVideoScreen(
                    videoViewModel = videoViewModel
                )
            }
            composable(Screen.ListFileCache.route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Graph.InternalStorage)
                }
                val videoViewModel: VideoViewModel = hiltViewModel(parentEntry)
                ListFileCache(
                    videoViewModel = videoViewModel
                )
            }
        }
    }
}