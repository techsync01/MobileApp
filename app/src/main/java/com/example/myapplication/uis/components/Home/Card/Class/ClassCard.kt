package com.example.myapplication.uis.components.Home.Card.Class


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.model.Home.Class.ClassItem

@Composable
fun ClassCard(item: ClassItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(item.teacherAvatar), null,
                        Modifier.size(24.dp).clip(CircleShape)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(item.teacher)
                }
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator(item.progress, color = item.color, trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.fillMaxWidth().height(6.dp))
                Spacer(Modifier.height(8.dp))
                Text("Performance", fontSize = 12.sp)
            }
            Spacer(Modifier.width(12.dp))
            ProgressRing(item.progress, item.obtained, item.total, item.color)
        }
    }
}

