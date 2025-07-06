package com.example.interviewselectcalendar.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Created by AidenChang on 2025/7/5
 */
class MainViewmodel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()
}