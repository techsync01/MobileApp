package com.example.myapplication.uis.components.Home.Card


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.model.Home.Timetable.NoteType
import com.example.myapplication.uis.model.Home.Timetable.ScheduleItem

@Composable
fun ScheduleCard(item: ScheduleItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = item.time,
            modifier = Modifier.width(60.dp),
            color = Color.Gray,
            fontSize = 12.sp
        )
        Spacer(Modifier.width(8.dp))
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(item.color)
                )
                Spacer(Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = item.className, fontWeight = FontWeight.Bold)
                    Text(text = item.subject, color = Color.Gray)
                    item.note?.let {
                        val noteColor = when (item.noteType) {
                            NoteType.INFO -> Color.Blue
                            NoteType.TEST -> Color(0xFFFFC107)
                            NoteType.REVISION -> Color(0xFFE91E63)
                            else -> Color.Gray
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = noteColor,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(text = it, color = noteColor, fontSize = 12.sp)
                        }
                    }
                }
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.Gray
                )
            }
        }
    }
}
