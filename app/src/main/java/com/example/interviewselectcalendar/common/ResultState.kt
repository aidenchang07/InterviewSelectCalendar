package com.example.interviewselectcalendar.common

/**
 * Created by AidenChang on 2025/7/6
 *
 * Api回來的狀態
 */
sealed class ResultState<out T>: StateType<T> {
    data object Loading : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val message: String?) : ResultState<Nothing>()
}