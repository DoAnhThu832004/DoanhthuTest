package com.example.roadmapaperolesson3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadmapaperolesson3.datasoure.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val _uiState = MutableStateFlow("Hello from Hilt ViewModel!")
    val uiState: StateFlow<String> = _uiState
    val freeCount = dataStoreManager.freeCountFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(500), 0)
    fun useOneFree() {
        viewModelScope.launch {
            val current = freeCount.value
            if(current > 0) {
                dataStoreManager.setFreeCount(current-1)
            }
        }
    }
}
