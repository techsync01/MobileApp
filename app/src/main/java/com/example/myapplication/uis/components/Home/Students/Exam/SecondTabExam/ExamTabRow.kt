package com.example.myapplication.uis.components.Home.Students.Exam.SecondTabExam

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExamTabRow(
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    val tabs = listOf("Report Card", "Exams")
    val primaryColor = MaterialTheme.colorScheme.primary
    val textOnPrimary = MaterialTheme.colorScheme.onPrimary
    val textDefault = MaterialTheme.colorScheme.onSurface

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        tabs.forEach { title ->
            val isSelected = selectedTab == title

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)

                    .background(
                        color = if (isSelected) primaryColor else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { onTabSelected(title) }
                    .border(
                        width = 1.dp,
                        color = if (isSelected) primaryColor else Color.Gray.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (isSelected) textOnPrimary else textDefault
                )
            }
        }
    }
}
