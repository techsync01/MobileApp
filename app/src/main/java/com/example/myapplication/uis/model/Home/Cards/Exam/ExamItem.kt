package com.example.myapplication.uis.model.Home.Cards.Exam


data class ExamItem(
    val className: String,
    val section: String,
    val subjects: List<String>,
    val color: Long // Pass color as Long (Color(0xFF...) value)
)
