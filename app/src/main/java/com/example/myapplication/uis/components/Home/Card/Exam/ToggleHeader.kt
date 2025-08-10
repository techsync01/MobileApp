package com.example.myapplication.uis.components.Home.Card.Exam


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun ToggleHeader(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.Center
    ) {
        listOf("Report Card", "Exam").forEach { tab ->
            val isSelected = tab == selectedTab
            Button(
                onClick = { onTabSelected(tab) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0xFF8B5CF6) else Color.White,
                    contentColor = if (isSelected) Color.White else Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text(tab)
            }
        }
    }
}
