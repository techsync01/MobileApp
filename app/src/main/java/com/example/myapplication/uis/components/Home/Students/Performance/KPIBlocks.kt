package com.example.myapplication.uis.components.Home.Students.Performance


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KPIRow(
    overallPercent: Int,
    assignments: Pair<Int, Int>,
    attendancePercent: Int
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        KPIBigTile(
            modifier = Modifier.weight(1f),
            percent = overallPercent,
            title = "Result",
            footer = "UT‑I+UT‑II+HY",
            bg = Color(0xFFFF8A3D)
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            KPIDualTile(
                numberTop = "${assignments.first}/${assignments.second}",
                title = "Assignment Submitted",
                bg = Color(0xFFFFC400)
            )
            KPIDualTile(
                numberTop = "$attendancePercent%",
                title = "Attendance",
                bg = Color(0xFF4CC9A6)
            )
        }
    }
}

@Composable
private fun KPIBigTile(
    modifier: Modifier,
    percent: Int,
    title: String,
    footer: String,
    bg: Color
) {
    Card(
        modifier = modifier.height(150.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bg),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = .2f)),
                contentAlignment = Alignment.Center
            ) {
                Text("📋", fontSize = 18.sp)
            }
            Text("$percent%", color = Color.White, fontSize = 32.sp)
            Text(title, color = Color.White, fontSize = 14.sp)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White.copy(alpha = .2f))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(footer, color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun KPIDualTile(
    numberTop: String,
    title: String,
    bg: Color
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bg),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(69.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(numberTop, color = Color.White, fontSize = 26.sp)
                Text(title, color = Color.White, fontSize = 14.sp)
            }
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = .2f)),
                contentAlignment = Alignment.Center
            ) {
                Text("🎓", fontSize = 16.sp)
            }
        }
    }
}
