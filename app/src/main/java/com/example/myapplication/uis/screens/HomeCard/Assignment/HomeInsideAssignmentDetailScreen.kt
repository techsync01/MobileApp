package com.example.myapplication.uis.screens.HomeCard.Assignment


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Assignments.AssignmentTopBar

@Composable
fun HomeInsideAssignmentDetailScreen(title: String, navController: NavController) {
    Scaffold(
        topBar = { AssignmentTopBar(title = title, onBackClick = { navController.popBackStack() }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add detail action */ }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            Text("Assignment Details", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(12.dp))
            Text("Here is some dummy text about the assignment details. You can replace this with real data later.")
        }
    }
}
