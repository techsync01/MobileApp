package com.example.myapplication.uis.components.Home.Students.Exam


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun VerticalText(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = androidx.compose.ui.Modifier.graphicsLayer {
            rotationZ = -90f
        }
    )
}
