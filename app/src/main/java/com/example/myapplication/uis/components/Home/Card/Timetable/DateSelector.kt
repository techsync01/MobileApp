


package com.example.myapplication.uis.components.Home.Card.Timetable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Purple700
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DateSelector(
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {
    val today = LocalDate.now()
    val startOfWeek = today.with(DayOfWeek.MONDAY)
    val dateFormatter = DateTimeFormatter.ofPattern("dd")

    val daysOfWeek = (0..6).map { offset ->
        val date = startOfWeek.plusDays(offset.toLong())
        val dayLabel = date.dayOfWeek.name.take(3)
        val isToday = date == today
        Triple(date.format(dateFormatter), dayLabel, isToday)
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(daysOfWeek) { (date, day, isToday) ->
            val isSelected = date == selectedDate

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) Purple700 else Color.White)
                    .clickable { onDateSelected(date) }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = if (isToday) "$day" else day,
                    color = if (isSelected) Color.White else Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = date,
                    color = if (isSelected) Color.White else Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
