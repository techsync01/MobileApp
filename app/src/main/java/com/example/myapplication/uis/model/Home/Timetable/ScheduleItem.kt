package com.example.myapplication.uis.model.Home.Timetable

import androidx.compose.ui.graphics.Color
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter


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
    private val dateFormatter = DateTimeFormatter.ofPattern("dd")

    // Automatically generates schedule for the past 5 days + today
    private val generatedData: Map<String, List<ScheduleItem>> by lazy {
        val today = LocalDate.now()
        val daysBack = 5

        (0..daysBack).associate { offset ->
            val date = today.minusDays(offset.toLong())
            val dateStr = date.format(dateFormatter)
            val dayOfWeek = date.dayOfWeek

            val schedule = when {
                dayOfWeek == DayOfWeek.SUNDAY -> emptyList() // Holiday
                offset == 0 -> listOf(
                    ScheduleItem("7:30 AM", "Class VI-A", "Science", null, null, Color(0xFF4CAF50)),
                    ScheduleItem("8:00 AM", "Class VI-B", "Science", "Surprise test of chapter 5", NoteType.TEST, Color(0xFF673AB7)),
                    ScheduleItem("9:00 AM", "Class V-A", "English", "Grammar Vocab", NoteType.INFO, Color(0xFF03A9F4)),
                    ScheduleItem("10:00 AM", "Class VI-A", "English", "Revision", NoteType.REVISION, Color(0xFFE91E63)),
                    ScheduleItem("11:00–11:45 AM", "", "", isBreak = true, color = Color.Transparent),
                    ScheduleItem("11:45 AM", "Class VI-A", "Science", null, null, Color(0xFFFF9800)),
                    ScheduleItem("12:15 PM", "Class VI-B", "Science", "Surprise test of chapter 5", NoteType.TEST, Color(0xFFFFC107)),
                    ScheduleItem("1:00 PM", "", "", isLeave = true, color = Color.Transparent)
                )
                offset == 1 -> listOf(
                    ScheduleItem("7:30 AM", "Class VI-A", "Math", "Quiz", NoteType.TEST, Color(0xFF673AB7)),
                    ScheduleItem("9:00 AM", "Class V-A", "English", "Reading Comprehension", NoteType.INFO, Color(0xFF03A9F4)),
                    ScheduleItem("10:00 AM", "Class VI-A", "English", "Revision", NoteType.REVISION, Color(0xFFE91E63))
                )
                offset == 2 -> listOf(
                    ScheduleItem("8:00 AM", "Class VI-B", "Science", "Group Project", NoteType.INFO, Color(0xFFFF9800)),
                    ScheduleItem("9:30 AM", "Class VI-A", "Math", "Practice Problems", NoteType.REVISION, Color(0xFF009688))
                )
                offset == 3 -> listOf(
                    ScheduleItem("8:00 AM", "Class VI-A", "Science", null, null, Color(0xFF4CAF50)),
                    ScheduleItem("11:00–11:45 AM", "", "", isBreak = true, color = Color.Transparent),
                    ScheduleItem("11:45 AM", "Class VI-A", "Science", null, null, Color(0xFFFF9800))
                )
                offset == 4 -> listOf(
                    ScheduleItem("10:00 AM", "Class VI-B", "English", "Speech Practice", NoteType.INFO, Color(0xFF3F51B5))
                )
                offset == 5 -> listOf(
                    ScheduleItem("8:00 AM", "Class V-B", "Math", "Unit Test", NoteType.TEST, Color(0xFFFF5722))
                )
                else -> emptyList()
            }

            dateStr to schedule
        }
    }

    fun getScheduleForDate(date: String): List<ScheduleItem> {
        return generatedData[date] ?: emptyList()
    }

    fun isHoliday(dateStr: String): Boolean {
        return try {
            val today = LocalDate.now()
            val fullDate = today.withDayOfMonth(dateStr.toInt())
            fullDate.dayOfWeek == DayOfWeek.SUNDAY
        } catch (e: Exception) {
            false
        }
    }
}
