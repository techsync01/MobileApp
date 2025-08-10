package com.example.myapplication.uis.components.Home.Card.Exam


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Class.StudentDetails
import com.example.myapplication.uis.model.Home.Class.getRankColor

@Composable
fun StudentItem(student: StudentDetails, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(50.dp)) {
                Icon(
                    painter = painterResource(id = student.image),
                    contentDescription = student.name,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    tint = Color.Unspecified
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .background(getRankColor(student.roleNumber), shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = String.format("%02d", student.roleNumber),
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = student.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "Make report card >>", color = Color(0xFF8B5CF6))
            }
        }
    }
}
