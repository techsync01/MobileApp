

package com.example.myapplication.uis.components.Home.Students.Performance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.myapplication.uis.model.Home.Class.ExamType

@Composable
fun ExamTypeDropdown(
    selectedExam: ExamType,
    onExamChange: (ExamType) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val label = when (selectedExam) {
        ExamType.HALF_YEARLY -> "Half Yearly Exams"
        ExamType.FINAL -> "Final Exams"
    }

    Box {
        Box(
            modifier = Modifier
                .widthIn(min = 160.dp)
                .background(Color(0xFFF6F1FF), RoundedCornerShape(10.dp))
                .clickable { expanded = !expanded }
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(text = label, color = Color(0xFF6C63FF))
        }

        if (expanded) {
            Popup(onDismissRequest = { expanded = false }) {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Column {
                        DropdownItem("Half Yearly Exams") {
                            onExamChange(ExamType.HALF_YEARLY)
                            expanded = false
                        }
                        DropdownItem("Final Exams") {
                            onExamChange(ExamType.FINAL)
                            expanded = false
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DropdownItem(text: String, onClick: () -> Unit) {
    Text(
        text,
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        color = Color(0xFF6C63FF)
    )
}
