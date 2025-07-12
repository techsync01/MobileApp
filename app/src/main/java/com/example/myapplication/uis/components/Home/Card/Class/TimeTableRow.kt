package com.example.myapplication.uis.components.Home.Card.Class

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.components.Home.Card.Timetable.TimeLineBreak
import com.example.myapplication.uis.model.Home.Class.TimeTableEntry


@Composable
fun TimeTableRow(entry: TimeTableEntry) {
    if (entry.isBreak) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
//            Text(
//                text = entry.breakLabel,
//                color = Color(0xFF7C4DFF),
//                fontWeight = FontWeight.Bold
//            )
//            Spacer(Modifier.width(8.dp))
//            Divider(
//                color = Color(0xFF7C4DFF),
//                thickness = 1.dp,
//                modifier = Modifier.weight(1f)
//            )
            TimeLineBreak(entry.timestamp,entry.label)
        }
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 12.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = entry.subject, fontWeight = FontWeight.Bold)
                    Text(
                        text = "${entry.time} • ${entry.topic}",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                Image(
                    painter = painterResource(id = entry.teacherAvatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}
