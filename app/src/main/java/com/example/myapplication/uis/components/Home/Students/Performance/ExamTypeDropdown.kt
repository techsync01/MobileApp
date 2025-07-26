package com.example.myapplication.uis.components.Home.Students.Performance


import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Class.ExamType

@OptIn(ExperimentalMaterial3Api::class)
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

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            readOnly = true,
            value = label,
            onValueChange = {},
            modifier = Modifier.menuAnchor().widthIn(min = 160.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF6F1FF),
                unfocusedContainerColor = Color(0xFFF6F1FF),
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            singleLine = true
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listOf(ExamType.HALF_YEARLY, ExamType.FINAL).forEach {
                DropdownMenuItem(
                    text = {
                        Text(
                            if (it == ExamType.HALF_YEARLY) "Half Yearly Exams" else "Final Exams"
                        )
                    },
                    onClick = {
                        onExamChange(it)
                        expanded = false
                    }
                )
            }
        }
    }
}
