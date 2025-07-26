package com.example.myapplication.uis.components.Home.Students.Performance


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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.model.Home.Class.SubjectAttendance

@Composable
fun AttendanceSubjectCard(subject: SubjectAttendance) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF2FA)),
        elevation = CardDefaults.cardElevation(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Start)
            ) {
                DonutChart(
                    percent = subject.percentage,
                    size = 48.dp,
                    thickness = 8.dp,
                    primary = Color(0xFF8150FF),
                    secondary = Color(0xFFFF8A3D)
                )
                Text(
                    "${subject.percentage}%",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 12.sp
                )
            }
            Text(subject.subject, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
            Text("${subject.present}/${subject.total}", color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun DonutChart(
    percent: Int,
    size: Dp,
    thickness: Dp,
    primary: Color,
    secondary: Color
) {
    Canvas(modifier = Modifier.size(size)) {
        val strokeWidth = thickness.toPx()
        drawArc(
            color = secondary,
            startAngle = -90f,
            sweepAngle = 360f * (1f - percent / 100f),
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
        drawArc(
            color = primary,
            startAngle = -90f,
            sweepAngle = 360f * (percent / 100f),
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
    }
}
