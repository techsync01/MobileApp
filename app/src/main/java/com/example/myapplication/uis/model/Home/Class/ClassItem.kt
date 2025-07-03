package com.example.myapplication.uis.model.Home.Class

import androidx.compose.ui.graphics.Color
import androidx.annotation.DrawableRes

data class ClassItem(
    val title: String,
    val teacher: String,
    @DrawableRes val teacherAvatar: Int,
    val progress: Float, // e.g., 0.73f for 73%
    val obtained: Int,
    val total: Int,
    val color: Color
)
