package com.example.myapplication.uis.model.Home.Class


import java.time.LocalDate

data class AssignmentItem(
    val subject: String,
    val title: String,
    val submissionDate: LocalDate,
    val isSubmitted: Boolean
)



object AssignmentRepository {
    fun getAssignments(): List<AssignmentItem> {
        return listOf(
            AssignmentItem(
                subject = "Mathematics",
                title = "Introduction to Pythagorean theorem",
                submissionDate = LocalDate.of(2025, 7, 19),
                isSubmitted = true
            ),
            AssignmentItem(
                subject = "Science",
                title = "Chemical reaction and their important parameters",
                submissionDate = LocalDate.of(2025, 7, 6),
                isSubmitted = false
            )
        )
    }
}
