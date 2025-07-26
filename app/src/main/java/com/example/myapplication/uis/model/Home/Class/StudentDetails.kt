package com.example.myapplication.uis.model.Home.Class


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Assignment
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class StudentFeature(
    val title: String,
    val icon: ImageVector,
    val color: Color,
    val routeBuilder: (Int) -> String
)

val featureCards: List<StudentFeature> = listOf(
    StudentFeature(
        "Performance",
        Icons.Outlined.BarChart,
        Color(0xFF4CC9A6)
    ) { id -> "student/$id/performance" },

    StudentFeature(
        "Attendance",
        Icons.Outlined.Person,
        Color(0xFFB39DFF)
    ) { id -> "student/$id/attendance" },

    StudentFeature(
        "Information",
        Icons.Outlined.Description,
        Color(0xFF64B5F6)
    ) { id -> "student/$id/information" },

    StudentFeature(
        "Fee Details",
        Icons.Outlined.AttachMoney,
        Color(0xFFFF7096)
    ) { id -> "student/$id/feeDetails" },

    StudentFeature(
        "Participations",
        Icons.Outlined.MonitorHeart,
        Color(0xFFFF8A3D)
    ) { id -> "student/$id/participations" },

    StudentFeature(
        "Assignments",
        Icons.Outlined.Assignment,
        Color(0xFFFFC400)
    ) { id -> "student/$id/assignments" },

    StudentFeature(
        "Chat With Parents",
        Icons.Outlined.Chat,
        Color(0xFF7E74FF)
    ) { id -> "student/$id/chatWithParents" },

    StudentFeature(
        "Chat With Student",
        Icons.Outlined.Chat,
        Color(0xFF9CC36A)
    ) { id -> "student/$id/chatWithStudent" }
)
