package com.example.roadmapaperolesson3.view.general

sealed class Screen(val route: String) {
    object FreeCountScreen : Screen("free_count_screen")
    object SaveNameScreen : Screen("save_name_screen")
    object CacheVideoScreen : Screen("cache_video_screen")
    object ListFileCache : Screen("list_file_cache")
    object SelectApp : Screen("select_app")
    object DataStoreScreen : Screen("data_store_screen")
    object InternalStorageScreen : Screen("internal_storage_screen")
}