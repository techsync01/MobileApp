

package com.example.myapplication.uis.components.Attendance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Attendance.DummyAttendanceData
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun AttendanceDateSelector(selectedDate: String, onDateSelected: (String) -> Unit) {
    val today = LocalDate.now()
    val startOfWeek = today.with(DayOfWeek.MONDAY)

    // This builds a list of 7 dates (Mon–Sun)
    val daysOfWeek = remember {
        (0..6).map { offset ->
            val date = startOfWeek.plusDays(offset.toLong())
            val dateStr = date.format(DateTimeFormatter.ofPattern("dd"))
            val dayLabel = date.dayOfWeek.name.take(3)
            val isToday = date == today
            Triple(dateStr, dayLabel, isToday)
        }
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(daysOfWeek) { (dateStr, dayLabel, isToday) ->
            val date = startOfWeek.withDayOfMonth(dateStr.toInt()) // Reconstruct full date
            val isSelected = dateStr == selectedDate
            val isSunday = date.dayOfWeek == DayOfWeek.SUNDAY

            val allAbsent = DummyAttendanceData.isAllAbsentForDate(dateStr)
            val anyPresent = DummyAttendanceData.isAnyPresent(dateStr)

            val bgColor = when {
                isSelected -> Color(0xFFFFC107)   // Selected = Yellow
                isSunday -> Color(0xFFA5D6A7)     // Sunday = Light Green
                isToday -> Color(0xFF4CAF50)      // Today = Green
                allAbsent -> Color(0xFFF44336)    // All Absent = Red
                anyPresent -> Color(0xFF4CAF50)   // Any Present = Green
                else -> Color.White
            }

            val textColor = if (bgColor == Color.White) Color.Black else Color.White

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(bgColor)
                    .clickable { onDateSelected(dateStr) }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = dayLabel,
                    color = textColor,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = dateStr,
                    color = textColor,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
