//package com.example.myapplication.uis.model.Home.Class
//
//import androidx.compose.ui.graphics.Color
//import com.example.myapplication.R
//
//
//data class StudentDetails(
//    val id: Int,
//    val name: String,
//    val phone: String,
//    val image: Int,
//    val percentage: Int
//)
//
//
//
//val dummyStudents = listOf(
//    StudentDetails(1, "Harshvardhan", "+91-8873562256", R.drawable.avtar1, 98),
//    StudentDetails(2, "Riya", "+91-8873562256", R.drawable.avtar1, 96),
//    StudentDetails(3, "Ashutosh", "+91-8873562256", R.drawable.avtar1, 94),
//    StudentDetails(4, "Anish Taneja", "+91-8873562256", R.drawable.avtar1, 80),
//    StudentDetails(5, "Apoorva Singh", "+91-8873562256", R.drawable.avtar1, 87),
//    StudentDetails(6, "Bhavesh Jha", "+91-8873562256", R.drawable.avtar1, 64),
//    StudentDetails(7, "Neha Sharma", "+91-8873562256", R.drawable.avtar1, 91),
//    StudentDetails(8, "Rahul Verma", "+91-8873562256", R.drawable.avtar1, 89),
//    StudentDetails(9, "Sneha Patel", "+91-8873562256", R.drawable.avtar1, 85),
//    StudentDetails(10, "Karan Singh", "+91-8873562256", R.drawable.avtar1, 82),
//    StudentDetails(11, "Pooja Gupta", "+91-8873562256", R.drawable.avtar1, 78),
//    StudentDetails(12, "Vikram Desai", "+91-8873562256", R.drawable.avtar1, 75),
//    StudentDetails(13, "Divya Rao", "+91-8873562256", R.drawable.avtar1, 72),
//    StudentDetails(14, "Siddharth Joshi", "+91-8873562256", R.drawable.avtar1, 70),
//    StudentDetails(15, "Rohan Mehta", "+91-8873562256", R.drawable.avtar1, 68),
//    StudentDetails(16, "Anjali Kulkarni", "+91-8873562256", R.drawable.avtar1, 65),
//    StudentDetails(17, "Manish Kumar", "+91-8873562256", R.drawable.avtar1, 62),
//    StudentDetails(18, "Simran Kaur", "+91-8873562256", R.drawable.avtar1, 60)
//)
//
//
//fun getRankColor(rank: Int): Color {
//    val colors = listOf(
//        Color(0xFF8B5CF6),
//        Color(0xFF6C63FF),
//        Color(0xFFE63946),
//        Color(0xFFB39DDB)
//    )
//    return colors[(rank - 1) % colors.size]
//}
//
//



//
//package com.example.myapplication.uis.model.Home.Class
//
//import androidx.compose.ui.graphics.Color
//import com.example.myapplication.R
//import kotlin.random.Random
//
//// -------------------- STUDENT LIST --------------------
//data class StudentDetails(
//    val id: Int,
//    val name: String,
//    val phone: String,
//    val image: Int,
//    val percentage: Int
//)
//
//val dummyStudents = listOf(
//    StudentDetails(1, "Harshvardhan", "+91-8873562256", R.drawable.avtar1, 98),
//    StudentDetails(2, "Riya", "+91-8873562256", R.drawable.avtar1, 96),
//    StudentDetails(3, "Ashutosh", "+91-8873562256", R.drawable.avtar1, 94),
//    StudentDetails(4, "Anish Taneja", "+91-8873562256", R.drawable.avtar1, 80),
//    StudentDetails(5, "Apoorva Singh", "+91-8873562256", R.drawable.avtar1, 87),
//    StudentDetails(6, "Bhavesh Jha", "+91-8873562256", R.drawable.avtar1, 64),
//    StudentDetails(7, "Neha Sharma", "+91-8873562256", R.drawable.avtar1, 91),
//    StudentDetails(8, "Rahul Verma", "+91-8873562256", R.drawable.avtar1, 89),
//    StudentDetails(9, "Sneha Patel", "+91-8873562256", R.drawable.avtar1, 85),
//    StudentDetails(10, "Karan Singh", "+91-8873562256", R.drawable.avtar1, 82),
//    StudentDetails(11, "Pooja Gupta", "+91-8873562256", R.drawable.avtar1, 78),
//    StudentDetails(12, "Vikram Desai", "+91-8873562256", R.drawable.avtar1, 75),
//    StudentDetails(13, "Divya Rao", "+91-8873562256", R.drawable.avtar1, 72),
//    StudentDetails(14, "Siddharth Joshi", "+91-8873562256", R.drawable.avtar1, 70),
//    StudentDetails(15, "Rohan Mehta", "+91-8873562256", R.drawable.avtar1, 68),
//    StudentDetails(16, "Anjali Kulkarni", "+91-8873562256", R.drawable.avtar1, 65),
//    StudentDetails(17, "Manish Kumar", "+91-8873562256", R.drawable.avtar1, 62),
//    StudentDetails(18, "Simran Kaur", "+91-8873562256", R.drawable.avtar1, 60)
//)
//
//// -------------------- RANK COLOR --------------------
//fun getRankColor(rank: Int): Color {
//    val colors = listOf(
//        Color(0xFF8B5CF6),
//        Color(0xFF6C63FF),
//        Color(0xFFE63946),
//        Color(0xFFB39DDB)
//    )
//    return colors[(rank - 1) % colors.size]
//}
//
//// -------------------- PERFORMANCE MODELS --------------------
//enum class ExamType { HALF_YEARLY, FINAL }
//
//data class SubjectResult(
//    val subject: String,
//    val maxMarks: Int,
//    val obtainedMarks: Int,
//    val grade: String
//)
//
//data class SubjectAttendance(
//    val subject: String,
//    val percentage: Int,
//    val present: Int,
//    val total: Int
//)
//
//data class OverallData(
//    val resultPercentage: Int
//)
//
//data class PositionData(
//    val position: Int,
//    val totalStudents: Int,
//    val score: Int
//)
//
//data class StudentPerformanceData(
//    val overall: Map<ExamType, OverallData>,
//    val assignments: Map<ExamType, Pair<Int, Int>>, // submitted/total
//    val attendanceOverall: Map<ExamType, Int>, // percentage
//    val position: Map<ExamType, PositionData>,
//    val reportCards: Map<ExamType, List<SubjectResult>>,
//    val attendanceBySubject: Map<ExamType, List<SubjectAttendance>>
//)
//
//// -------------------- RANDOM DATA GENERATOR --------------------
//private fun generateRandomPerformance(seed: Int): StudentPerformanceData {
//    val random = Random(seed)
//
//    val subjects = listOf(
//        "Mathematics", "Science", "Social Science",
//        "Hindi", "Computer", "Drawing", "Physical Education"
//    )
//
//    fun randomMarks(): Int = random.nextInt(40, 100)
//    fun randomGrade(score: Int): String = when {
//        score >= 90 -> "A1"
//        score >= 80 -> "A"
//        score >= 70 -> "B1"
//        score >= 60 -> "B"
//        score >= 50 -> "C"
//        score >= 40 -> "D"
//        else -> "Fail"
//    }
//
//    fun createResults(): List<SubjectResult> =
//        subjects.map { sub ->
//            val obtained = randomMarks()
//            SubjectResult(sub, 100, obtained, randomGrade(obtained))
//        }
//
//    fun createAttendance(): List<SubjectAttendance> =
//        subjects.map {
//            val total = random.nextInt(100, 120)
//            val present = random.nextInt(70, total)
//            SubjectAttendance(it, (present * 100) / total, present, total)
//        }
//
//    return StudentPerformanceData(
//        overall = mapOf(
//            ExamType.HALF_YEARLY to OverallData(random.nextInt(60, 85)),
//            ExamType.FINAL to OverallData(random.nextInt(65, 95))
//        ),
//        assignments = mapOf(
//            ExamType.HALF_YEARLY to Pair(random.nextInt(4, 9), 9),
//            ExamType.FINAL to Pair(random.nextInt(5, 10), 10)
//        ),
//        attendanceOverall = mapOf(
//            ExamType.HALF_YEARLY to random.nextInt(60, 90),
//            ExamType.FINAL to random.nextInt(70, 95)
//        ),
//        position = mapOf(
//            ExamType.HALF_YEARLY to PositionData(random.nextInt(1, 15), 40, random.nextInt(70, 95)),
//            ExamType.FINAL to PositionData(random.nextInt(1, 10), 40, random.nextInt(75, 98))
//        ),
//        reportCards = mapOf(
//            ExamType.HALF_YEARLY to createResults(),
//            ExamType.FINAL to createResults()
//        ),
//        attendanceBySubject = mapOf(
//            ExamType.HALF_YEARLY to createAttendance(),
//            ExamType.FINAL to createAttendance()
//        )
//    )
//}
//
//// -------------------- REPOSITORY --------------------
//object DummyPerformanceRepo {
//    private val studentPerformanceMap: Map<Int, StudentPerformanceData> =
//        dummyStudents.associate { student ->
//            student.id to generateRandomPerformance(student.id)
//        }
//
//    fun getPerformance(studentId: Int): StudentPerformanceData {
//        return studentPerformanceMap[studentId] ?: generateRandomPerformance(studentId)
//    }
//}



package com.example.myapplication.uis.model.Home.Class

import androidx.compose.ui.graphics.Color
import com.example.myapplication.R
import kotlin.random.Random

// -------------------- STUDENT LIST --------------------
data class StudentDetails(
    val id: Int,
    val name: String,
    val phone: String,
    val image: Int,
    val percentage: Int
)

val dummyStudents = listOf(
    StudentDetails(1, "Harshvardhan", "+91-8873562256", R.drawable.avtar1, 98),
    StudentDetails(2, "Riya", "+91-8873562256", R.drawable.avtar1, 96),
    StudentDetails(3, "Ashutosh", "+91-8873562256", R.drawable.avtar1, 94),
    StudentDetails(4, "Anish Taneja", "+91-8873562256", R.drawable.avtar1, 80),
    StudentDetails(5, "Apoorva Singh", "+91-8873562256", R.drawable.avtar1, 87),
    StudentDetails(6, "Bhavesh Jha", "+91-8873562256", R.drawable.avtar1, 64),
    StudentDetails(7, "Neha Sharma", "+91-8873562256", R.drawable.avtar1, 91),
    StudentDetails(8, "Rahul Verma", "+91-8873562256", R.drawable.avtar1, 89),
    StudentDetails(9, "Sneha Patel", "+91-8873562256", R.drawable.avtar1, 85),
    StudentDetails(10, "Karan Singh", "+91-8873562256", R.drawable.avtar1, 82),
    StudentDetails(11, "Pooja Gupta", "+91-8873562256", R.drawable.avtar1, 78),
    StudentDetails(12, "Vikram Desai", "+91-8873562256", R.drawable.avtar1, 75),
    StudentDetails(13, "Divya Rao", "+91-8873562256", R.drawable.avtar1, 72),
    StudentDetails(14, "Siddharth Joshi", "+91-8873562256", R.drawable.avtar1, 70),
    StudentDetails(15, "Rohan Mehta", "+91-8873562256", R.drawable.avtar1, 68),
    StudentDetails(16, "Anjali Kulkarni", "+91-8873562256", R.drawable.avtar1, 65),
    StudentDetails(17, "Manish Kumar", "+91-8873562256", R.drawable.avtar1, 62),
    StudentDetails(18, "Simran Kaur", "+91-8873562256", R.drawable.avtar1, 60)
)

// -------------------- RANK COLOR --------------------
fun getRankColor(rank: Int): Color {
    val colors = listOf(
        Color(0xFF8B5CF6),
        Color(0xFF6C63FF),
        Color(0xFFE63946),
        Color(0xFFB39DDB)
    )
    return colors[(rank - 1) % colors.size]
}

// -------------------- PERFORMANCE MODELS --------------------
enum class ExamType { HALF_YEARLY, FINAL }

data class SubjectResult(
    val subject: String,
    val maxMarks: Int,
    val obtainedMarks: Int,
    val grade: String
)

data class SubjectAttendance(
    val subject: String,
    val percentage: Int,
    val present: Int,
    val total: Int
)

data class OverallData(
    val resultPercentage: Int
)

data class PositionData(
    val position: Int,
    val totalStudents: Int,
    val score: Int
)

data class StudentPerformanceData(
    val overall: Map<ExamType, OverallData>,
    val assignments: Map<ExamType, Pair<Int, Int>>, // submitted/total
    val attendanceOverall: Map<ExamType, Int>, // percentage
    val position: Map<ExamType, PositionData>,
    val reportCards: Map<ExamType, List<SubjectResult>>,
    val attendanceBySubject: Map<ExamType, List<SubjectAttendance>>
)

// -------------------- RANDOM DATA GENERATOR --------------------
private fun generatePerformanceForStudent(student: StudentDetails): StudentPerformanceData {
    val random = Random(student.id)

    val subjects = listOf(
        "Mathematics", "Science", "Social Science",
        "Hindi", "Computer", "Drawing", "Physical Education"
    )

    // Convert percentage to approximate total marks out of 100 per subject
    fun subjectMarks(basePercentage: Int): Int {
        val variation = random.nextInt(-10, 10)
        return (basePercentage + variation).coerceIn(40, 100)
    }

    fun grade(score: Int): String = when {
        score >= 90 -> "A1"
        score >= 80 -> "A"
        score >= 70 -> "B1"
        score >= 60 -> "B"
        score >= 50 -> "C"
        score >= 40 -> "D"
        else -> "Fail"
    }

    fun createResults(base: Int): List<SubjectResult> =
        subjects.map { sub ->
            val marks = subjectMarks(base)
            SubjectResult(sub, 100, marks, grade(marks))
        }

    fun createAttendance(): List<SubjectAttendance> =
        subjects.map {
            val total = random.nextInt(100, 120)
            val present = (total * student.percentage) / 100
            SubjectAttendance(it, (present * 100) / total, present, total)
        }

    val rank = dummyStudents.sortedByDescending { it.percentage }
        .indexOf(student) + 1

    return StudentPerformanceData(
        overall = mapOf(
            ExamType.HALF_YEARLY to OverallData(student.percentage),
            ExamType.FINAL to OverallData((student.percentage + random.nextInt(-5, 5)).coerceIn(50, 100))
        ),
        assignments = mapOf(
            ExamType.HALF_YEARLY to Pair(random.nextInt(4, 9), 9),
            ExamType.FINAL to Pair(random.nextInt(5, 10), 10)
        ),
        attendanceOverall = mapOf(
            ExamType.HALF_YEARLY to (student.percentage - 5).coerceIn(50, 100),
            ExamType.FINAL to (student.percentage + random.nextInt(-3, 3)).coerceIn(50, 100)
        ),
        position = mapOf(
            ExamType.HALF_YEARLY to PositionData(rank, dummyStudents.size, student.percentage),
            ExamType.FINAL to PositionData(rank, dummyStudents.size, student.percentage + random.nextInt(-3, 3))
        ),
        reportCards = mapOf(
            ExamType.HALF_YEARLY to createResults(student.percentage),
            ExamType.FINAL to createResults((student.percentage + random.nextInt(-5, 5)).coerceIn(50, 100))
        ),
        attendanceBySubject = mapOf(
            ExamType.HALF_YEARLY to createAttendance(),
            ExamType.FINAL to createAttendance()
        )
    )
}

// -------------------- REPOSITORY --------------------
object DummyPerformanceRepo {
    private val studentPerformanceMap: Map<Int, StudentPerformanceData> =
        dummyStudents.associate { student ->
            student.id to generatePerformanceForStudent(student)
        }

    fun getPerformance(studentId: Int): StudentPerformanceData {
        return studentPerformanceMap[studentId]
            ?: generatePerformanceForStudent(dummyStudents.first())
    }
}
