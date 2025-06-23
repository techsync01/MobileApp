package com.example.myapplication.uis.components.Achievement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ClassTabs(tabs: List<String>, selected: String, onTabSelected: (String) -> Unit) {
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        tabs.forEach {
            val isSelected = it == selected
            Button (
                onClick = { onTabSelected(it) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0xFF7C4DFF) else Color.White,
                    contentColor = if (isSelected) Color.White else Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(it)
            }
        }
    }
}
