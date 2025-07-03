package com.example.myapplication.uis.screens.Class


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun ClassDetailScreen(className: String, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Class $className") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column (modifier = Modifier.padding(padding).padding(16.dp)) {
            Text(text = "Details for Class $className", style = MaterialTheme.typography.titleLarge)
            // Add detailed UI here
        }
    }
}
