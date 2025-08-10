package com.example.myapplication.uis.screens.HomeCard.Exam.Inside


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.model.Home.Cards.Exam.DummyPerformanceRepo

@Composable
fun MakeReportScreen(studentId: Int, navController: NavController) {
    val performance = DummyPerformanceRepo.getPerformanceById(studentId)
    val subjectStates = remember { mutableStateListOf<Pair<String, String>>() }

    LaunchedEffect(Unit) {
        performance?.subjects?.forEach {
            subjectStates.add(it.name to it.marks.toString())
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Make Report", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.fillMaxHeight().weight(1f)) {
            items(subjectStates.size) { index ->
                val (subject, marks) = subjectStates[index]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(subject, modifier = Modifier.weight(1f))
                    BasicTextField(
                        value = marks,
                        onValueChange = { new ->
                            subjectStates[index] = subject to new
                        },
                        modifier = Modifier
                            .width(60.dp)
                            .background(Color.LightGray, RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                }
            }
        }

        Button(
            onClick = {
                // Update logic placeholder
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}
