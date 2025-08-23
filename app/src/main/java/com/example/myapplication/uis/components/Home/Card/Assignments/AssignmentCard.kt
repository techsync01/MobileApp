package com.example.myapplication.uis.components.Home.Card.Assignments


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Assignments.Assignment

@Composable
fun AssignmentCard(
    assignment: Assignment,
    onClick: (Assignment) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick(assignment) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Class Circle
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(assignment.bgColor))
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = assignment.className,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(Modifier.weight(1f)) {
                Text(text = assignment.section, style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(4.dp))




                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy((-12).dp) // negative spacing = overlap
                    ) {
                        assignment.avatars.take(3).forEach { avatar ->
                            Image(
                                painter = painterResource(id = avatar),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(RoundedCornerShape(50))
                                    .border(2.dp, Color.White, RoundedCornerShape(50)) // optional cleaner overlap
                            )
                        }
                    }

                    Spacer(Modifier.width(8.dp)) // small space before "+More"

                    Text(
                        text = "+${assignment.moreCount} More",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Last Assignment published: ${assignment.lastPublished}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}
