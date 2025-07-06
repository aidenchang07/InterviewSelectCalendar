package com.example.interviewselectcalendar.presentation

import com.example.interviewselectcalendar.common.StateType

/**
 * Created by AidenChang on 2025/7/6
 *
 * Ui的狀態
 */
sealed class UiState<out T>: StateType<T> {
    data object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}