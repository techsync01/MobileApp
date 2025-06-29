

package com.example.myapplication.uis.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Home.Card.Timetable.DateSelector
import com.example.myapplication.uis.components.Home.Card.Timetable.ScheduleCard
import com.example.myapplication.uis.components.Home.Card.Timetable.TimeLineBreak
import com.example.myapplication.uis.model.Home.Timetable.DummyScheduleData
import java.time.LocalDate
import java.time.format.DateTimeFormatter

val Purple500 = Color(0xFF6200EE)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTableScreen(onBack: () -> Unit) {
    val today = LocalDate.now()
    val dateFormatter = DateTimeFormatter.ofPattern("dd")
    var selectedDate by remember { mutableStateOf(today.format(dateFormatter)) }

    val schedule = remember(selectedDate) {
        DummyScheduleData.getScheduleForDate(selectedDate)
    }
    val fullDateLabel = remember(selectedDate) {
        val today = LocalDate.now().withDayOfMonth(selectedDate.toInt())
        val formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy") // e.g., Tuesday, 06 May 2025
        today.format(formatter)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Purple500)
    ) {
        TopAppBar(
            title = { Text("Time Table", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Purple500,
                titleContentColor = Color.White
            )
        )

        DateSelector(selectedDate = selectedDate, onDateSelected = { selectedDate = it })


        Text(
            text = fullDateLabel,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            color = Color(0xFFF5F7FB)
        ) {
            LazyColumn(modifier = Modifier.padding(vertical = 8.dp)) {
                items(schedule) { item ->
                    when {
                        item.isBreak -> TimeLineBreak(time = item.time, label = "Lunch Break")
                        item.isLeave -> TimeLineBreak(time = item.time, label = "Leave")
                        else -> ScheduleCard(item)
                    }
                }
            }
        }
    }
}
