package com.example.myapplication.uis.model.Syllabus


import androidx.compose.ui.graphics.Color
import com.example.myapplication.R

data class SyllabusItem(
    val title: String,
    val classLevel: String,
    val rating: Float,
    val chapters: Int,
    val type: String = "NCERT",
    val backgroundColor: Color,
    val titleColor: Color = Color.White,
    val iconColor: Color = Color.White
)
