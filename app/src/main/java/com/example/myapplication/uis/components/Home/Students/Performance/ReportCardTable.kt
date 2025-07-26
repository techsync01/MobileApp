package com.example.myapplication.uis.components.Home.Students.Performance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Class.ExamType
import com.example.myapplication.uis.model.Home.Class.SubjectResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportCardSection(
    selectedExam: ExamType,
    onExamChange: (ExamType) -> Unit,
    results: List<SubjectResult>
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Report Card",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                ExamTypeDropdown(selectedExam, onExamChange)
            }

            Spacer(Modifier.height(16.dp))
            ReportCardTable(results)
        }
    }
}

@Composable
fun ReportCardTable(results: List<SubjectResult>) {
    val purpleDark = Color(0xFF5E32D5)
    val purpleMid = Color(0xFF744BEE)
    val purpleLight = Color(0xFFB39DFF)

    Column {
        results.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = row.subject,
                    modifier = Modifier.weight(1.3f),
                    style = MaterialTheme.typography.bodyMedium
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        .background(purpleDark, RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)),
                    contentAlignment = Alignment.Center
                ) { Text("${row.maxMarks}", color = Color.White) }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        .background(purpleMid),
                    contentAlignment = Alignment.Center
                ) { Text("${row.obtainedMarks}", color = Color.White) }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        .background(purpleLight, RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)),
                    contentAlignment = Alignment.Center
                ) { Text(row.grade, color = Color.White) }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.weight(1.3f))
            SidePill("Max Marks", Color(0xFF4822BC), Modifier.weight(1f))
            SidePill("Marks Obtained", Color(0xFF623AD8), Modifier.weight(1f))
            SidePill("Grade", Color(0xFF9275FF), Modifier.weight(1f))
        }
    }
}

@Composable
private fun SidePill(text: String, color: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .height(22.dp)
            .background(color, RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color.White, style = MaterialTheme.typography.labelSmall)
    }
}
