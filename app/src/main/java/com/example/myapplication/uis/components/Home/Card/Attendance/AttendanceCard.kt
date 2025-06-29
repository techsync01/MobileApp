

package com.example.myapplication.uis.components.Attendance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Home.Card.Attendance.TimeLineLabel
import com.example.myapplication.uis.model.Attendance.AttendanceClass
import com.example.myapplication.uis.model.Attendance.AttendanceStatus

@Composable
fun AttendanceCard(item: AttendanceClass) {
    if (item.isBreak) {
        TimeLineLabel(item.time, "Lunch Break")
    } else if (item.isLeave) {
        TimeLineLabel(item.time, "Leave")
    } else {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = item.time,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 2.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(item.subject, style = MaterialTheme.typography.titleMedium)
                    Text(item.teacher, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                    if (item.status == AttendanceStatus.PRESENT) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF4CAF50))
                            Text("Present", color = Color(0xFF4CAF50), modifier = Modifier.padding(start = 4.dp))
                        }
                    } else {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFFF44336))
                            Text("Absent", color = Color(0xFFF44336), modifier = Modifier.padding(start = 4.dp))
                        }
                    }
                }
            }
        }
    }
}
