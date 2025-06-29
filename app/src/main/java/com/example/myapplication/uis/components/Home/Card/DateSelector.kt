package com.example.myapplication.uis.components.Home.Card


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

@Composable
fun DateSelector(selectedDate: String, onDateSelected: (String) -> Unit) {
    val days = listOf(
        "05" to "MON",
        "06" to "TUE",
        "07" to "WED",
        "08" to "THU",
        "09" to "FRI",
        "10" to "SAT"
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(days) { (date, day) ->
            val isSelected = date == selectedDate
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        color = if (isSelected) Purple700 else Color.White
                    )
                    .clickable { onDateSelected(date) }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = day,
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

