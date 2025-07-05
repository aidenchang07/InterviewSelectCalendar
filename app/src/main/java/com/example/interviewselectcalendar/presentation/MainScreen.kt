package com.example.interviewselectcalendar.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

/**
 * Created by AidenChang on 2025/7/5
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val today by remember { mutableStateOf(LocalDate.now()) }
    var startDate by remember { mutableStateOf(today) }
    var endDate by remember { mutableStateOf(today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))) }
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                title = {
                    Text(text = "${startDate.format(formatter)} - ${endDate.format(formatter)}")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            val newStart = startDate.minusWeeks(1)
                            // 計算今天 (today) 跟剛推算出來的 newStart 差了幾天
                            val daysBetween = ChronoUnit.DAYS.between(today, newStart)
                            // 如果 newStart 距離 today 少於 7 天，且 today 晚於 newStart，
                            // 表示這一推就會跨越到「本週」範圍之外（只要一週內就直接回 today）
                            startDate = if (daysBetween < 7 && today.isAfter(newStart)) {
                                // 差距小於一週，直接重設回今天
                                today
                            } else {
                                // 否則就保留剛推算出來的 newStart
                                newStart
                            }
                            endDate = endDate.minusWeeks(1)
                        },
                        enabled = today.isBefore(startDate) // 判斷是否可以返回上一週
                    ) {
                        Icon(Icons.Default.ArrowBack, "上一週")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            // 下一組：start = 上組結束 +1；end = start +6
                            startDate = endDate.plusDays(1)
                            endDate = startDate.plusDays(6)
                        }
                    ) {
                        Icon(Icons.Default.ArrowForward, "下一週")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}