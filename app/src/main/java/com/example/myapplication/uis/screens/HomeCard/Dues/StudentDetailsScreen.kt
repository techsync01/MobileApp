package com.example.myapplication.uis.screens.HomeCard.Dues


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.model.Home.Class.dummyStudents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDetailsScreen(navController: NavController, studentId: Int) {
    val student = dummyStudents.firstOrNull { it.id == studentId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(student?.name ?: "Student") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Student Details", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(8.dp))
            Text("Name: ${student?.name}")
            Text("Phone: ${student?.phone}")
            Text("Father: ${student?.fathersName}")
            Text("Mother: ${student?.mothersName}")
        }
    }
}
