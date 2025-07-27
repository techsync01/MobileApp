package com.example.myapplication.uis.screens.Class.features


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Home.Students.Assignment.AssignmentCard
import com.example.myapplication.uis.model.Home.Class.AssignmentRepository
import com.example.myapplication.uis.model.Home.Class.dummyStudents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssignmentsScreen(studentId: Int, onBack: () -> Unit) {
    val student = dummyStudents.find { it.id == studentId } ?: dummyStudents[0]
    val assignments = AssignmentRepository.getAssignments()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(student.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Search functionality */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F7FC))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(assignments) { assignment ->
                AssignmentCard(assignment = assignment)
            }
        }
    }
}
