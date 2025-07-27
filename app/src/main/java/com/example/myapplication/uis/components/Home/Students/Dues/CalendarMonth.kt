package com.example.myapplication.uis.components.Home.Students.Dues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

private val WeekDays = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")

@Composable
fun CalendarMonth(
    month: YearMonth,
    today: LocalDate,
    paidDates: Set<LocalDate>,
    modifier: Modifier = Modifier,
    todayColor: Color = Color(0xFF8150FF),
    paidColor: Color = Color(0xFFFF5E99),
    disabledColor: Color = Color(0xFFBDBDBD)
) {
    Column(modifier = modifier) {

        // Days of week header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WeekDays.forEachIndexed { idx, label ->
                val color = if (idx == 0) Color(0xFFFF2D55) else Color(0xFF7C7C7C)
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = color,
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }

        val firstOfMonth = month.atDay(1)
        val daysInMonth = month.lengthOfMonth()
        val firstDayOfWeekIndex = (firstOfMonth.dayOfWeek.value % 7) // Sunday = 0
        val totalCells = firstDayOfWeekIndex + daysInMonth
        val rows = (totalCells + 6) / 7

        Column {
            var day = 1
            repeat(rows) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    repeat(7) { column ->
                        val cellIndex = it * 7 + column
                        if (cellIndex < firstDayOfWeekIndex || day > daysInMonth) {
                            // empty
                            Box(modifier = Modifier.weight(1f).height(36.dp))
                        } else {
                            val date = month.atDay(day)
                            val isToday = date == today
                            val isPaid = date in paidDates
                            val notThisMonth = false

                            val dotColor = when {
                                isToday -> todayColor
                                isPaid -> paidColor
                                else -> Color.Transparent
                            }

                            DayCell(
                                modifier = Modifier.weight(1f),  // Weight applied here
                                text = day.toString(),
                                isDisabled = notThisMonth,
                                textColor = if (notThisMonth) disabledColor else Color.Black,
                                highlightColor = dotColor
                            )


                            day++
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DayCell(
    modifier: Modifier = Modifier,
    text: String,
    isDisabled: Boolean,
    textColor: Color,
    highlightColor: Color
) {
    Box(
        modifier = modifier
            .height(36.dp),
        contentAlignment = Alignment.Center
    ) {
        if (highlightColor != Color.Transparent) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(highlightColor, CircleShape)
            )
        }
        Text(
            text = text,
            color = if (isDisabled) textColor.copy(alpha = .5f) else textColor,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}


