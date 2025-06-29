package com.example.myapplication.uis.model.Home.Timetable

import androidx.compose.ui.graphics.Color



data class ScheduleItem(
    val time: String,
    val className: String,
    val subject: String,
    val note: String? = null,
    val noteType: NoteType? = null,
    val color: Color,
    val isBreak: Boolean = false,
    val isLeave: Boolean = false
)

enum class NoteType {
    INFO, TEST, REVISION,OTHER
}


// Dummy data provider (could be placed in a separate file)
object DummyScheduleData {
    fun getScheduleForDate(date: String): List<ScheduleItem> {
        return when (date) {
            "05" -> listOf(
                ScheduleItem("8:00 AM", "Class VI-A", "Science", "Test on Chapter 2", NoteType.TEST, Color(0xFF4CAF50)),
                ScheduleItem("10:00 AM", "Class V-B", "English", "Worksheet Review", NoteType.INFO, Color(0xFF03A9F4))
            )
            "06" -> listOf(
                ScheduleItem("7:30 AM", "Class VI-A", "Science", null, null, Color(0xFF4CAF50)),
                ScheduleItem("8:00 AM", "Class VI-B", "Science", "Surprise test of chapter 5", NoteType.TEST, Color(0xFF673AB7)),
                ScheduleItem("9:00 AM", "Class V-A", "English", "Grammar Vocab", NoteType.INFO, Color(0xFF03A9F4)),
                ScheduleItem("10:00 AM", "Class VI-A", "English", "Revision", NoteType.REVISION, Color(0xFFE91E63)),
                ScheduleItem("11:00–11:45 AM", "", "", isBreak = true, color = Color.Transparent),
                ScheduleItem("11:45 AM", "Class VI-A", "Science", null, null, Color(0xFFFF9800)),
                ScheduleItem("12:15 PM", "Class VI-B", "Science", "Surprise test of chapter 5", NoteType.TEST, Color(0xFFFFC107)),
                ScheduleItem("1:00 PM", "", "", isLeave = true, color = Color.Transparent)
            )
            else -> listOf(
                ScheduleItem("9:00 AM", "Class VI-A", "Math", "Chapter 8 Practice", NoteType.REVISION, Color(0xFF009688)),
                ScheduleItem("11:00 AM", "Class V-B", "English", null, null, Color(0xFF03A9F4))
            )
        }
    }
}
