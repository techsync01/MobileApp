package com.example.myapplication.uis.components.Profile


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileActions() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { /* logout */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C4DFF)),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(0.6f),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Logout")
        }

        Text(
            "Delete Account",
            color = Color.Gray,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}
