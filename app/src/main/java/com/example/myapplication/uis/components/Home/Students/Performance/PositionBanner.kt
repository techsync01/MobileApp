package com.example.myapplication.uis.components.Home.Students.Performance


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PositionBanner(rank: Int, total: Int, progress: Int) {
    val purple = Color(0xFF8150FF)

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = purple),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("👑", fontSize = 22.sp)
                    Spacer(Modifier.width(6.dp))
                    Text("${rank}th", color = Color.White, fontSize = 34.sp)
                }
                Text("Position in Class", color = Color.White, fontSize = 16.sp)
                Text("Overall Result", color = Color.White.copy(alpha = .6f), fontSize = 14.sp)
            }

            CircularRing(progress, size = 64.dp, stroke = 8.dp, color = Color.White)
        }
    }
}

@Composable
private fun CircularRing(percent: Int, size: Dp, stroke: Dp, color: Color) {
    val sweep = animateFloatAsState(
        targetValue = percent / 100f,
        label = "ring"
    )

    Box(modifier = Modifier.size(size), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokePx = stroke.toPx()
            // track
            drawArc(
                color = color.copy(alpha = .2f),
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = androidx.compose.ui.graphics.drawscope.Stroke(strokePx, cap = StrokeCap.Round)
            )
            // progress
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360f * sweep.value,
                useCenter = false,
                style = androidx.compose.ui.graphics.drawscope.Stroke(strokePx, cap = StrokeCap.Round)
            )
        }
        Text("$percent%", color = Color.White)
    }
}
