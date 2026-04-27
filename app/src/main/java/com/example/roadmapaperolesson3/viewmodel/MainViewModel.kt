package com.example.roadmapaperolesson3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadmapaperolesson3.datasoure.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val _uiState = MutableStateFlow("Hello from Hilt ViewModel!")
    val uiState: StateFlow<String> = _uiState
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()
    val freeCount = dataStoreManager.freeCountFlow
        .stateIn(viewModelScope, SharingStarted.Companion.WhileSubscribed(500), 0)
    val nameUser = dataStoreManager.nameUserFlow
        .stateIn(viewModelScope, SharingStarted.Companion.WhileSubscribed(500), "Do Anh Thu")
    fun useOneFree() {
        viewModelScope.launch {
            val current = freeCount.value
            if(current > 0) {
                dataStoreManager.setFreeCount(current-1)
            }
        }
    }
    fun incrementFreeCount() {
        viewModelScope.launch {
            val current = freeCount.value
            val result = dataStoreManager.setFreeCount(current + 1)
            result.onFailure {
                _errorMessage.value = "Lỗi khi lưu giá trị"
            }
        }
    }
    fun decrementFreeCount() {
        viewModelScope.launch {
            val current = freeCount.value
            if(current > 0) {
                val result = dataStoreManager.setFreeCount(current - 1)
                result.onFailure {
                    _errorMessage.value = "Lỗi khi lưu giá trị"
                }
            }
        }
    }

    fun resetFreeCount() {
        viewModelScope.launch {
            val result =  dataStoreManager.setFreeCount(0)
            result.onFailure {
                _errorMessage.value = "Lỗi khi lưu giá trị"
            }
        }
    }
    fun updateUserName(name: String) {
        viewModelScope.launch {
            val result = dataStoreManager.setNameUser(name)
            result.onFailure {
                _errorMessage.value = "Lỗi khi lưu giá trị"
            }
        }
    }
    fun clearError() {
        _errorMessage.value = null
    }
}