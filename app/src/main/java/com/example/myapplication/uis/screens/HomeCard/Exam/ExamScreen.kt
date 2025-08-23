package com.example.myapplication.uis.screens.HomeCard.Exam


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Exam.*
import com.example.myapplication.uis.components.Home.Students.Exam.SecondTabExam.ExamItemCard
import com.example.myapplication.uis.components.Home.Students.Exam.SecondTabExam.ExamMenuBar
import com.example.myapplication.uis.model.Home.Cards.Exam.approvedExams
import com.example.myapplication.uis.model.Home.Cards.Exam.historyExams
import com.example.myapplication.uis.model.Home.Cards.Exam.inReviewExams
import com.example.myapplication.uis.model.Home.Cards.Exam.revertedExams
import com.example.myapplication.uis.model.Home.Class.*

@Composable
fun ExamScreen(navController: NavController) {
    var selectedMenu by remember { mutableStateOf("Approved") }

    Column(modifier = Modifier.fillMaxSize()) {
        ExamMenuBar (selected = selectedMenu, onSelected = { selectedMenu = it })

        val data = when (selectedMenu) {
            "Approved" -> approvedExams
            "In Review" -> inReviewExams
            "Reverted" -> revertedExams
            "History" -> historyExams
            else -> approvedExams
        }

        LazyColumn {
            items(data) { exam ->
                ExamItemCard(exam = exam)
            }
        }
    }
}
