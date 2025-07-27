package com.example.myapplication.uis.components.Home.Students.Dues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarHeader(
    currentMonth: YearMonth,
    onPrev: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier,
    titleColor: Color = Color.White
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val monthTitle =
            "${currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} ${currentMonth.year}"
        Text(
            text = monthTitle,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = titleColor
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            IconButton(
                onClick = onPrev,
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.White.copy(alpha = .15f), shape = MaterialTheme.shapes.medium)
            ) {
                Icon(Icons.Outlined.ChevronLeft, contentDescription = "Previous", tint = Color.White)
            }
            IconButton(
                onClick = onNext,
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.White.copy(alpha = .15f), shape = MaterialTheme.shapes.medium)
            ) {
                Icon(Icons.Outlined.ChevronRight, contentDescription = "Next", tint = Color.White)
            }
        }
    }
}
