


package com.example.myapplication.uis.model.Attendance

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class AttendanceClass(
    val time: String,
    val subject: String,
    val teacher: String,
    val status: AttendanceStatus,
    val isBreak: Boolean = false,
    val isLeave: Boolean = false,
)

enum class AttendanceStatus {
    PRESENT, ABSENT
}




object DummyAttendanceData {
    private val dateFormatter = DateTimeFormatter.ofPattern("dd")

    // Generate dynamic attendance for the past 5 days till today
    private val generatedData: Map<String, List<AttendanceClass>> by lazy {
        val today = LocalDate.now()
        val daysBack = 6

        (0..daysBack).associate { offset ->
            val date = today.minusDays(offset.toLong())
            val dateStr = date.format(dateFormatter)
            val dayOfWeek = date.dayOfWeek

            val classes = when {
                dayOfWeek == DayOfWeek.SUNDAY -> emptyList() // Holiday
                offset == 0 -> listOf( // Today – All present
                    AttendanceClass("10:00 AM", "English Class", "You", AttendanceStatus.PRESENT),
                    AttendanceClass("11:00–11:45 AM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("11:45 AM", "Hindi Class", "Amrita Khanna", AttendanceStatus.PRESENT),
                    AttendanceClass("12:15 PM", "Physical Education", "Gaurav Chaudhary", AttendanceStatus.PRESENT),
                    AttendanceClass("01:00 PM", "", "", AttendanceStatus.PRESENT, isLeave = true),
                    AttendanceClass("02:00 PM", "English Class", "You", AttendanceStatus.PRESENT),
                    AttendanceClass("03:00–03:45 PM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("03:45 PM", "Hindi Class", "Amrita Khanna", AttendanceStatus.PRESENT),
                    AttendanceClass("04:15 PM", "Physical Education", "Gaurav Chaudhary", AttendanceStatus.PRESENT),
                    AttendanceClass("05:00 PM", "", "", AttendanceStatus.PRESENT, isLeave = true)
                )
                offset == 1 -> listOf( // Yesterday – All absent
                    AttendanceClass("10:00 AM", "English Class", "You", AttendanceStatus.ABSENT),
                    AttendanceClass("11:00–11:45 AM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("11:45 AM", "Hindi Class", "Amrita Khanna", AttendanceStatus.ABSENT),
                    AttendanceClass("12:15 PM", "Physical Education", "Gaurav Chaudhary", AttendanceStatus.ABSENT),
                    AttendanceClass("01:00 PM", "", "", AttendanceStatus.PRESENT, isLeave = true)
                )
                offset == 2 -> listOf( // Mixed attendance
                    AttendanceClass("10:00 AM", "Math Class", "You", AttendanceStatus.PRESENT),
                    AttendanceClass("11:00–11:45 AM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("11:45 AM", "Science", "Nisha Verma", AttendanceStatus.ABSENT)
                )
                offset == 3 -> listOf( // Partial attendance
                    AttendanceClass("10:00 AM", "English Class", "You", AttendanceStatus.PRESENT),
                    AttendanceClass("11:00–11:45 AM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("11:45 AM", "Hindi Class", "Amrita Khanna", AttendanceStatus.PRESENT),
                    AttendanceClass("12:15 PM", "Physical Education", "Gaurav Chaudhary", AttendanceStatus.PRESENT),
                    AttendanceClass("01:00 PM", "", "", AttendanceStatus.PRESENT, isLeave = true),
                    AttendanceClass("02:00 PM", "English Class", "You", AttendanceStatus.PRESENT),
                    AttendanceClass("03:00–03:45 PM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("03:45 PM", "Hindi Class", "Amrita Khanna", AttendanceStatus.PRESENT),
                    AttendanceClass("04:15 PM", "Physical Education", "Gaurav Chaudhary", AttendanceStatus.PRESENT),
                    AttendanceClass("05:00 PM", "", "", AttendanceStatus.PRESENT, isLeave = true)
                )
                offset == 4 -> listOf( // Only one class
                    AttendanceClass("10:00 AM", "English", "You", AttendanceStatus.PRESENT)
                )
                offset == 5 -> listOf( // Partial attendance
                    AttendanceClass("10:00 AM", "Biology", "You", AttendanceStatus.ABSENT),
                    AttendanceClass("11:00–11:45 AM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("11:45 AM", "Chemistry", "Nisha Verma", AttendanceStatus.PRESENT)
                )
                offset == 6 -> listOf( // Today – All present
                    AttendanceClass("10:00 AM", "English Class", "You", AttendanceStatus.ABSENT),
                    AttendanceClass("11:00–11:45 AM", "", "", AttendanceStatus.PRESENT, isBreak = true),
                    AttendanceClass("11:45 AM", "Hindi Class", "Amrita Khanna", AttendanceStatus.ABSENT),
                    AttendanceClass("12:15 PM", "Physical Education", "Gaurav Chaudhary", AttendanceStatus.ABSENT),
                    AttendanceClass("01:00 PM", "", "", AttendanceStatus.PRESENT, isLeave = true)
                )

                else -> emptyList()
            }

            dateStr to classes
        }
    }

    fun getScheduleForDate(date: String): List<AttendanceClass> {
        return generatedData[date] ?: emptyList()
    }

    fun isAllAbsentForDate(date: String): Boolean {
        val items = getScheduleForDate(date)
        val filtered = items.filterNot { it.isBreak || it.isLeave }
        return filtered.isNotEmpty() && filtered.all { it.status == AttendanceStatus.ABSENT }
    }

    fun isAnyPresent(date: String): Boolean {
        return getScheduleForDate(date).any { it.status == AttendanceStatus.PRESENT }
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

