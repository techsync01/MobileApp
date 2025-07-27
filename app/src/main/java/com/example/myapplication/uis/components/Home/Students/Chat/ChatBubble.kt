package com.example.myapplication.uis.components.Home.Students.Chat


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Class.ChatMessage
import java.time.format.DateTimeFormatter

@Composable
fun ChatBubble(
    message: ChatMessage,
    showAvatar: Boolean
) {
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        horizontalArrangement = if (message.isMine) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        if (!message.isMine) {
            if (showAvatar && message.avatar != null) {
                Image(
                    painter = painterResource(id = message.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(6.dp))
            } else {
                Spacer(Modifier.width(34.dp)) // keep bubbles aligned without avatar
            }
        }

        Column(
            horizontalAlignment = if (message.isMine) Alignment.End else Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = if (message.isMine) Color(0xFFF0E9FF) else Color(0xFFF1F1F1),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = message.text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
            Spacer(Modifier.height(2.dp))
            Text(
                text = message.timestamp.format(timeFormatter),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}
