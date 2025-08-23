package com.example.myapplication.uis.components.Home.Students.Exam.SecondTabExam


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExamMenuBar(selected: String, onSelected: (String) -> Unit) {
    val menuItems = listOf("Approved", "In Review", "Reverted", "History","Data","English","hindi")

    LazyRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(menuItems) { item ->
            TextButton(
                onClick = { onSelected(item) }
            ) {
                Text(
                    text = item,
                    color = if (item == selected) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}
