package com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.LeaderBorad

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressWithLabel(
    score: Int,
    total: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    val progress = score / total.toFloat()

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(42.dp)
    ) {
        CircularProgressIndicator(
            progress = progress,
            strokeWidth = 4.dp,
            color = color,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "$score%",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black // or adjust to match theme
        )
    }
}
