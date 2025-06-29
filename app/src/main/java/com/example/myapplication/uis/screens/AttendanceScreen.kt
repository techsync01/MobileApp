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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Attendance.AttendanceCard
import com.example.myapplication.uis.components.Attendance.AttendanceDateSelector
import com.example.myapplication.uis.model.Attendance.DummyAttendanceData
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(onBack: () -> Unit) {
    val today = LocalDate.now()
    val dateFormatter = DateTimeFormatter.ofPattern("dd")
    val fullDateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")

    // By default, select today (e.g., "29")
    var selectedDate by remember { mutableStateOf(today.format(dateFormatter)) }

    val selectedFullDate = today.withDayOfMonth(selectedDate.toIntOrNull() ?: today.dayOfMonth)
    val schedule = remember(selectedDate) {
        DummyAttendanceData.getScheduleForDate(selectedDate)
    }
    val isHoliday = DummyAttendanceData.isHoliday(selectedDate)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple500)
    ) {
        // Top App Bar
        TopAppBar(
            title = { Text("Attendance", color = Color.White) },
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

        // Date Selector
        AttendanceDateSelector(
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        // Dynamic Full Date Label
        Text(
            text = selectedFullDate.format(fullDateFormatter),
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // Surface with either Holiday message or attendance list
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            color = Color(0xFFF5F7FB)
        ) {
            if (isHoliday) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Holiday 🎉",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFF4CAF50)
                    )
                    Text(
                        text = "No classes today",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            } else {
                LazyColumn(modifier = Modifier.padding(vertical = 8.dp)) {
                    items(schedule) { item ->
                        AttendanceCard(item)
                    }
                }
            }
        }
    }
}
