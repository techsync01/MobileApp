package com.example.myapplication.uis.components.Home.Students.Exam



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.screens.HomeCard.Exam.Inside.ReportCardEntry

@Composable
fun ReportRow(entry: ReportCardEntry) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(entry.title, modifier = Modifier.weight(1f))
        Text(entry.maxMarks, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(entry.obtained, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(entry.grade, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
    }
}
