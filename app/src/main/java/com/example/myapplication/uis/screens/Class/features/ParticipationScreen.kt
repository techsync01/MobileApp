package com.example.myapplication.uis.screens.Class.features


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Home.Students.Participation.ActivityCard
import com.example.myapplication.uis.model.Home.Class.ActivityRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParticipationScreen(onBack: () -> Unit) {
    val activities = ActivityRepository.getActivities()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Activity") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
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
            items(activities) { activity ->
                ActivityCard(activity = activity)
            }
        }
    }
}
