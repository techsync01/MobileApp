package com.example.myapplication.uis.components.Home.Card.Assignments


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssignmentTopBar(
    title: String = "Assignments",
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title, style = MaterialTheme.typography.titleLarge) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        modifier = Modifier
    )
}
