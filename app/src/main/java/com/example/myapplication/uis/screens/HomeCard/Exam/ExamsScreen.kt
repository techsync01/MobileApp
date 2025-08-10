package com.example.myapplication.uis.screens.HomeCard.Exam


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.uis.components.Home.Card.Exam.ExamCard
import com.example.myapplication.uis.components.Home.Card.Exam.ExamHeaderBar
import com.example.myapplication.uis.model.Home.Cards.Exam.ExamItem

@Composable
fun ExamsScreen(navController: NavHostController) {
    val exams = listOf(
        ExamItem("V", "Section-A", listOf("English", "Mathematics"), 0xFF21C1B4),
        ExamItem("IX", "Section-A", listOf("Chemistry"), 0xFF8150FF),
        ExamItem("V", "Section-A", listOf("English", "Mathematics"), 0xFF21A1F4),
        ExamItem("IX", "Section-A", listOf("Chemistry"), 0xFFF06292)
    )

    Scaffold(
        containerColor = Color(0xFFF9F9FF),
        topBar = {
            ExamHeaderBar (
                title = "Exams & Report Card",
                onBack = { navController.popBackStack() }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(padding)
        ) {
            items(exams) { exam ->
                ExamCard (item = exam) {
                    navController.navigate("exam_detail/${exam.className}")
                }
            }
        }
    }
}
