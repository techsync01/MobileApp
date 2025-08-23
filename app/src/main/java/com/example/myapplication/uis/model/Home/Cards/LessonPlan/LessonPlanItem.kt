package com.example.myapplication.uis.model.Home.Cards.LessonPlan


import androidx.compose.ui.graphics.Color
import com.example.myapplication.R

data class LessonPlanItem(
    val id: Int,
    val title: String,
    val chapter: String,
    val section: String,
    val dateRange: String,
    val flagColor: Color
)

object DummyLessonPlans {
    val lessons = listOf(
        LessonPlanItem(1, "Lesson Plan-Science", "Chapter 4 - Thumb rule", "V - A", "14 July 2025 - 19 July 2025", Color(0xFF4CAF50)),
        LessonPlanItem(2, "Lesson Plan-Science", "Chapter 4 - Thumb rule", "V - A", "14 July 2025 - 19 July 2025", Color(0xFF9C27B0)),
        LessonPlanItem(3, "Lesson Plan-Science", "Chapter 4 - Thumb rule", "V - A", "14 July 2025 - 19 July 2025", Color(0xFF2196F3)),
        LessonPlanItem(4, "Lesson Plan-Science", "Chapter 4 - Thumb rule", "V - A", "14 July 2025 - 19 July 2025", Color(0xFFE91E63)),
        LessonPlanItem(5, "Lesson Plan-Science", "Chapter 4 - Thumb rule", "V - A", "14 July 2025 - 19 July 2025", Color(0xFFFF9800)),
        LessonPlanItem(6, "Lesson Plan-Science", "Chapter 4 - Thumb rule", "V - A", "14 July 2025 - 19 July 2025", Color(0xFF3F51B5))
    )
}
