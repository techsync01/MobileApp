package com.example.myapplication.uis.model.Home.Cards.Exam

data class SubjectPerformance(val name: String, val marks: Int, val grade: String)

data class StudentPerformance(
    val studentId: Int,
    val subjects: List<SubjectPerformance>
)

object DummyPerformanceRepo {
    private val data = listOf(
        StudentPerformance(1, listOf(
            SubjectPerformance("English", 89, "A"),
            SubjectPerformance("Math", 74, "B"),
            SubjectPerformance("Science", 92, "A+")
        )),
        StudentPerformance(2, listOf(
            SubjectPerformance("English", 76, "B"),
            SubjectPerformance("Math", 81, "A"),
            SubjectPerformance("Science", 68, "C")
        ))
    )

    fun getPerformanceById(studentId: Int): StudentPerformance? {
        return data.find { it.studentId == studentId }
    }
}
