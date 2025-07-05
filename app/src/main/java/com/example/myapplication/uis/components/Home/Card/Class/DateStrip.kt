package com.example.myapplication.uis.components.Home.Card.Class

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DateStrip(
    dates: List<LocalDate>,
    selected: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        items(dates) { date ->
            val isSelected = date == selected
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isSelected) Color(0xFF7C4DFF) else Color(0xFFF0F0F0))
                    .clickable { onDateSelected(date) }
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            ) {
                Text(
                    text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                    color = if (isSelected) Color.White else Color.Gray
                )
                Text(
                    text = date.dayOfMonth.toString(),
                    color = if (isSelected) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
