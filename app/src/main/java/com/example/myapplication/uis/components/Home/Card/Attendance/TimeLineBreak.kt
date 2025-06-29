package com.example.myapplication.uis.components.Home.Card.Attendance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TimeLineLabel(time: String, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        // Time Box
        Text(
            text = time,
            color = Color(0xFF6200EE),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .background(Color(0xFFD1C4E9), shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )

        // Connecting Line
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color(0xFF6200EE))
                .padding(horizontal = 8.dp)
        )

        // Label Box
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .background(Color(0xFF6200EE), shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

