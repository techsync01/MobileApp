package com.example.myapplication.uis.components.Home.Students.Participation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import com.example.myapplication.uis.model.Home.Class.ActivityItem
import java.time.format.DateTimeFormatter

@Composable
fun ActivityCard(activity: ActivityItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            // Event Icon
            Image(
                painter = painterResource(id = activity.iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(40.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                // Date chip
                val dateText = if (activity.endDate != null) {
                    val formatter = DateTimeFormatter.ofPattern("MMM dd")
                    "${activity.startDate.format(formatter)} - ${activity.endDate.format(formatter)}"
                } else {
                    activity.startDate.format(DateTimeFormatter.ofPattern("MMM dd"))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    ActivityDateChip(dateText = dateText)
                }

                Spacer(Modifier.height(8.dp))
                Text(
                    text = activity.title,
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.Black)
                )

                Spacer(Modifier.height(4.dp))
                Text(
                    text = activity.description,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                )

                Spacer(Modifier.height(8.dp))
                ParticipantAvatars(avatars = activity.participants)
            }
        }
    }
}
