package com.example.myapplication.uis.components.Home.Students.Exam.SecondTabExam


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import com.example.myapplication.uis.model.Home.Cards.Exam.ExamItemData

@Composable
fun ExamItemCard(exam: ExamItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = exam.subject,
                    color = Color(android.graphics.Color.parseColor(exam.colorHex)),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = exam.duration, style = MaterialTheme.typography.bodySmall)
                Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor(exam.colorHex)).copy(alpha = 0.2f),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = exam.examType,
                        color = Color(android.graphics.Color.parseColor(exam.colorHex)),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.Edit, contentDescription = "Exam", modifier = Modifier.size(24.dp))
                Spacer(Modifier.width(8.dp))
                Text("${exam.marks} Marks")
            }
        }
    }
}
