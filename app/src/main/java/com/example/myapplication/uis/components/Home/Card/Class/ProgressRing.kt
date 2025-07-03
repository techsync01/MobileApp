package com.example.myapplication.uis.components.Home.Card.Class

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

@Composable
fun ProgressRing(
    percentage: Float,
    obtained: Int,
    total: Int,
    color: Color,
    size: Dp = 48.dp,
    strokeWidth: Dp = 6.dp
) {
    Box(modifier = Modifier.size(size), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.LightGray,
                style = Stroke(strokeWidth.toPx())
            )
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * percentage,
                useCenter = false,
                style = Stroke(strokeWidth.toPx())
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$obtained", style = MaterialTheme.typography.labelSmall)
            Text(text = "/$total", style = MaterialTheme.typography.labelSmall)
        }
    }
}
