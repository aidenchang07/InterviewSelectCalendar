package com.example.interviewselectcalendar.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by AidenChang on 2025/7/5
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                title = {
                    Text(text = "Interview Select Calendar")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            println("aiden click left")
                        }
                    ) {
                        Icon(Icons.Default.ArrowBack, "上一週")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            println("aiden click right")
                        }
                    ) {
                        Icon(Icons.Default.ArrowForward, "下一週")
                    }
                }
            )
        }
    ) { innerPadding ->

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}