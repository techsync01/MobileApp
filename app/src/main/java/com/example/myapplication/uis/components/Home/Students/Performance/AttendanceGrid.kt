package com.example.myapplication.uis.components.Home.Students.Performance


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Class.ExamType
import com.example.myapplication.uis.model.Home.Class.SubjectAttendance

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceSection(
    selectedExam: ExamType,
    onExamChange: (ExamType) -> Unit,
    subjects: List<SubjectAttendance>
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
            Row  {
                Text(
                    "Attendance",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                ExamTypeDropdown(selectedExam, onExamChange)
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.heightIn(min = 0.dp, max = 420.dp).padding(top = 12.dp)
            ) {
                items(subjects) { s ->
                    AttendanceSubjectCard(subject = s)
                }
            }
        }
    }
}
