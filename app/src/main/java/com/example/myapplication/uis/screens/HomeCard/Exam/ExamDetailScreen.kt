package com.example.myapplication.uis.screens.HomeCard.Exam

import com.example.myapplication.uis.components.Home.Card.Exam.ExamDummyScreen
import com.example.myapplication.uis.components.Home.Card.Exam.StudentItem
import com.example.myapplication.uis.components.Home.Card.Exam.ToggleHeader
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.myapplication.uis.model.Home.Class.dummyStudents

@Composable
fun ExamDetailScreen(className: String, navController: NavController) {
    var selectedTab by remember { mutableStateOf("Report Card") }

    Column(modifier = Modifier.fillMaxSize()) {
        ToggleHeader (selectedTab, onTabSelected = { selectedTab = it })

        when (selectedTab) {
            "Report Card" -> {
                Column {
                    dummyStudents.forEach { student ->
                        StudentItem (student = student, onClick = {
                            navController.navigate("report_card/${student.id}")
                        })
                    }
                }
            }
            "Exam" -> ExamDummyScreen(navController)
        }
    }
}


//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.myapplication.uis.components.Home.Card.Exam.ExamHeaderBar
//
//@Composable
//fun ExamDetailScreen(className: String, navController: NavHostController) {
//    Scaffold(
//        topBar = { ExamHeaderBar(title = "$className Exam", onBack = { navController.popBackStack() }) },
//        containerColor = Color(0xFFF9F9FF)
//    ) { padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .padding(16.dp)
//        ) {
//            Text("Details for Class $className exam will appear here.")
//            // Add more UI components as required
//        }
//    }
//}
