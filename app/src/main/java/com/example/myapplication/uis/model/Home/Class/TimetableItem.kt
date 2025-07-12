package com.example.myapplication.uis.model.Home.Class

// model/Home/Class/TimetableItem.kt

import androidx.annotation.DrawableRes


data class Student(val name: String, @DrawableRes val avatar: Int)

data class TimeTableEntry(
    val time: String,
    val subject: String,
    val topic: String,
    @DrawableRes val teacherAvatar: Int,
    val isBreak: Boolean = false,
    val timestamp: String = "",
    val label:String="s"
)
