package com.example.myapplication.uis.components.Home.Students.Assignment


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.uis.model.Home.Class.AssignmentItem
import java.time.format.DateTimeFormatter

@Composable
fun AssignmentCard(assignment: AssignmentItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Subject Icon
            Icon(
                painter = painterResource(id = R.drawable.avtar1), // add this icon
                contentDescription = null,
                tint = Color(0xFF8150FF),
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                // Subject
                Text(
                    text = assignment.subject,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                )

                // Title
                Text(
                    text = assignment.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Submission Date
                val dateText = assignment.submissionDate.format(
                    DateTimeFormatter.ofPattern("dd MMMM yyyy")
                )
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.avtar1), // add icon
                        contentDescription = null,
                        tint = if (assignment.isSubmitted) Color(0xFF1D9C64) else Color(0xFFD93025),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Submitted On: $dateText",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = if (assignment.isSubmitted) Color(0xFF1D9C64) else Color(0xFFD93025)
                        )
                    )
                }
            }
        }
    }
}
