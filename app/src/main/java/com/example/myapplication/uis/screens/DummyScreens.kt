package com.example.myapplication.uis.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
//import androidx.compose.ui.unit.PaddingValues

//@Composable
//fun AchievementsScreen(paddingValues: PaddingValues) {
//    CenteredTextScreen("Achievements", paddingValues)
//}

@Composable
fun ChatScreen() {
    CenteredTextScreen("Chat")
}

//@Composable
//fun DocsScreen(paddingValues: PaddingValues) {
//    CenteredTextScreen("Docs", paddingValues)
//}

//@Composable
//fun ProfileScreen(paddingValues: PaddingValues) {
//    CenteredTextScreen("Profile", paddingValues)
//}

@Composable
fun CenteredTextScreen(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F6FB)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7C4DFF)
        )
    }
}
