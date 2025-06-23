package com.example.myapplication.uis.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.components.Syllabus.SyllabusCard
import com.example.myapplication.uis.components.Syllabus.UploadCourseCard
import androidx.compose.ui.graphics.Color
import com.example.myapplication.uis.components.BottomNavbar.CustomBottomBar
import com.example.myapplication.uis.model.Syllabus.SyllabusItem

@Composable
fun SyllabusScreen() {
    val syllabusItems = listOf(
        SyllabusItem("English Literature", "VI", 4.5f, 11, backgroundColor = Color(0xFF7C4DFF)),
        SyllabusItem("English Grammar", "VI", 4.5f, 11, backgroundColor = Color(0xFF4CC6A1)),
        SyllabusItem("English Worksheet-1", "V", 4.5f, 11, backgroundColor = Color(0xFFFF5F5F)),
        SyllabusItem("Grammar Worksheet-2", "V", 4.5f, 11, backgroundColor = Color(0xFFFFD94C), titleColor = Color.DarkGray, iconColor = Color.DarkGray),
                SyllabusItem("English Literature", "VI", 4.5f, 11, backgroundColor = Color(0xFF7C4DFF)),
        SyllabusItem("English Grammar", "VI", 4.5f, 11, backgroundColor = Color(0xFF4CC6A1)),
        SyllabusItem("English Worksheet-1", "V", 4.5f, 11, backgroundColor = Color(0xFFFF5F5F)),
        SyllabusItem("Grammar Worksheet-2", "V", 4.5f, 11, backgroundColor = Color(0xFFFFD94C), titleColor = Color.DarkGray, iconColor = Color.DarkGray)
    )

    Scaffold(
//        bottomBar = { CustomBottomBar(selectedIndex = 3)
//        {} }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Syllabus",
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(12.dp))

            syllabusItems.forEach { item ->
                SyllabusCard(item)
            }

            UploadCourseCard()
        }
    }
}
