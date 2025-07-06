package com.example.interviewselectcalendar.presentation

/**
 * Created by AidenChang on 2025/7/6
 *
 * SelectCalendar的動作事件
 */
sealed interface SelectCalendarAction

/**
 * 點擊「上一週」的動作
 */
sealed class OnPrev : SelectCalendarAction

/**
 * 點擊「下一週」的動作
 */
sealed class OnNext : SelectCalendarAction