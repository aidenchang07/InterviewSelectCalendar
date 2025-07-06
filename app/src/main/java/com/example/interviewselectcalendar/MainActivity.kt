package com.example.interviewselectcalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.interviewselectcalendar.presentation.MainScreenRoot
import com.example.interviewselectcalendar.presentation.MainViewModel
import com.example.interviewselectcalendar.ui.theme.InterviewSelectCalendarTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterviewSelectCalendarTheme {
                MainScreenRoot(viewModel)
            }
        }
    }
}