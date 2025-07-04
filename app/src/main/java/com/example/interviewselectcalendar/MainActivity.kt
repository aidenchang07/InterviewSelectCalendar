package com.example.interviewselectcalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.interviewselectcalendar.presentation.MainScreen
import com.example.interviewselectcalendar.ui.theme.InterviewSelectCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterviewSelectCalendarTheme {
                MainScreen()
            }
        }
    }
}