package com.example.myapplication.uis.components.Home.Card.Exam


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExamDummyScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Exam Screen", style = MaterialTheme.typography.headlineMedium)
        Text("This is a dummy placeholder", style = MaterialTheme.typography.bodyMedium)
    }
}
