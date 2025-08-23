package com.example.myapplication.uis.model.Home.Cards.Exam


data class ExamItem(
    val className: String,
    val section: String,
    val subjects: List<String>,
    val color: Long // Pass color as Long (Color(0xFF...) value)
)


data class ExamItemData(
    val subject: String,
    val duration: String,
    val examType: String,
    val marks: Int,
    val colorHex: String
)

val approvedExams = listOf(
    ExamItemData("English", "00:45 Hours", "Unit Test-I", 50, "#FF7043"),
    ExamItemData("Mathematics", "00:45 Hours", "Unit Test-I", 50, "#FF7043"),
    ExamItemData("English", "00:45 Hours", "Unit Test-II", 50, "#42A5F5"),
    ExamItemData("Mathematics", "00:45 Hours", "Unit Test-II", 50, "#42A5F5"),
    ExamItemData("English", "02:00 Hours", "Half Yearly Exams", 100, "#26A69A"),
    ExamItemData("English", "00:45 Hours", "Unit Test-I", 50, "#FF7043"),
    ExamItemData("Mathematics", "00:45 Hours", "Unit Test-I", 50, "#FF7043"),
    ExamItemData("English", "00:45 Hours", "Unit Test-II", 50, "#42A5F5"),
    ExamItemData("Mathematics", "00:45 Hours", "Unit Test-II", 50, "#42A5F5"),
    ExamItemData("English", "02:00 Hours", "Half Yearly Exams", 100, "#26A69A"),
)

val inReviewExams = listOf(
    ExamItemData("Science", "01:00 Hours", "Unit Test-I", 40, "#8E24AA"),
    ExamItemData("History", "01:30 Hours", "Unit Test-II", 60, "#5C6BC0"),
)

val revertedExams = listOf(
    ExamItemData("Civics", "00:30 Hours", "Unit Test-I", 20, "#EF5350"),
)

val historyExams = listOf(
    ExamItemData("Geography", "01:00 Hours", "Annual Exams", 80, "#7CB342"),
)
