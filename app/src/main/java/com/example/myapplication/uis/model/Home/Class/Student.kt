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
    val percentage: Int,
    val email: String = "",
    val className: String = "",
    val roleNumber: Int = 0,
    val fathersName: String = "",
    val fathersContact: String = "",
    val mothersName: String = "",
    val mothersContact: String = "",
    val dateOfBirth: String = "",
    val admissionDate: String = "",
    val houseName: String = "",
    val permanentAddress: String = "",
    val isSubmitted: Boolean
)

// Represents one exam's mark entry
data class ExamMark(
    val examName: String,
    val totalMarks: String,
    val obtainedMarks: String
)

// Holds performance of a student
data class StudentPerformance(
    val marks: List<ExamMark>,
    val grades: List<String>
)



val dummyStudents = listOf(
    StudentDetails(
        1, "Harshvardhan", "+91-8873562256", R.drawable.avtar1, 98,
        email = "harsh@example.com", className = "V-A", roleNumber = 1,
        fathersName = "Rajesh Sharma", fathersContact = "+91-9876543210",
        mothersName = "Priya Sharma", mothersContact = "+91-8765432109",
        dateOfBirth = "15 Mar 2006", admissionDate = "10 Apr 2023",
        houseName = "Prakhar", permanentAddress = "H.No. 10, C-12, Sector-5, Noida, Uttar Pradesh 201301",true
    ),
    StudentDetails(
        2, "Riya", "+91-8873562256", R.drawable.avtar1, 96,
        email = "riya@example.com", className = "V-A", roleNumber = 2,
        fathersName = "Amit Patel", fathersContact = "+91-9876543211",
        mothersName = "Sunita Patel", mothersContact = "+91-8765432110",
        dateOfBirth = "20 May 2006", admissionDate = "12 Apr 2023",
        houseName = "Vikram", permanentAddress = "H.No. 15, C-14, Sector-6, Noida, Uttar Pradesh 201302",false
    ),
    StudentDetails(
        3, "Ashutosh", "+91-8873562256", R.drawable.avtar1, 94,
        email = "ashutosh@example.com", className = "V-A", roleNumber = 3,
        fathersName = "Vikram Singh", fathersContact = "+91-9876543212",
        mothersName = "Anita Singh", mothersContact = "+91-8765432111",
        dateOfBirth = "10 Jul 2006", admissionDate = "11 Apr 2023",
        houseName = "Arjun", permanentAddress = "H.No. 20, C-16, Sector-7, Noida, Uttar Pradesh 201303",false
    ),
    StudentDetails(
        4, "Anish Taneja", "+91-9875352416", R.drawable.avtar1, 80,
        email = "pathaklav12@gmail.com", className = "V-A", roleNumber = 1,
        fathersName = "Arun Taneja", fathersContact = "+91-8873548393",
        mothersName = "Minakshi Taneja", mothersContact = "+91-8873548393",
        dateOfBirth = "06 Aug 2006", admissionDate = "12 Apr 2023",
        houseName = "Prakhar", permanentAddress = "H.No. 32, C-16, Sector-67, Noida, Uttar Pradesh 201309",false
    ),
    StudentDetails(
        5, "Apoorva Singh", "+91-8873562256", R.drawable.avtar1, 87,
        email = "apoorva@example.com", className = "V-A", roleNumber = 5,
        fathersName = "Suresh Singh", fathersContact = "+91-9876543214",
        mothersName = "Meena Singh", mothersContact = "+91-8765432113",
        dateOfBirth = "25 Sep 2006", admissionDate = "13 Apr 2023",
        houseName = "Shiv", permanentAddress = "H.No. 25, C-18, Sector-8, Noida, Uttar Pradesh 201304",true
    ),
    StudentDetails(
        6, "Bhavesh Jha", "+91-8873562256", R.drawable.avtar1, 64,
        email = "bhavesh@example.com", className = "V-A", roleNumber = 6,
        fathersName = "Manoj Jha", fathersContact = "+91-9876543215",
        mothersName = "Lata Jha", mothersContact = "+91-8765432114",
        dateOfBirth = "12 Oct 2006", admissionDate = "14 Apr 2023",
        houseName = "Nitin", permanentAddress = "H.No. 30, C-20, Sector-9, Noida, Uttar Pradesh 201305",true
    ),
    StudentDetails(
        7, "Neha Sharma", "+91-8873562256", R.drawable.avtar1, 91,
        email = "neha@example.com", className = "V-A", roleNumber = 7,
        fathersName = "Rakesh Sharma", fathersContact = "+91-9876543216",
        mothersName = "Geeta Sharma", mothersContact = "+91-8765432115",
        dateOfBirth = "05 Nov 2006", admissionDate = "15 Apr 2023",
        houseName = "Ravi", permanentAddress = "H.No. 35, C-22, Sector-10, Noida, Uttar Pradesh 201306",false
    ),
    StudentDetails(
        8, "Rahul Verma", "+91-8873562256", R.drawable.avtar1, 89,
        email = "rahul@example.com", className = "V-A", roleNumber = 8,
        fathersName = "Vijay Verma", fathersContact = "+91-9876543217",
        mothersName = "Kavita Verma", mothersContact = "+91-8765432116",
        dateOfBirth = "18 Dec 2006", admissionDate = "16 Apr 2023",
        houseName = "Pranav", permanentAddress = "H.No. 40, C-24, Sector-11, Noida, Uttar Pradesh 201307",false
    ),
    StudentDetails(
        9, "Sneha Patel", "+91-8873562256", R.drawable.avtar1, 85,
        email = "sneha@example.com", className = "V-A", roleNumber = 9,
        fathersName = "Deepak Patel", fathersContact = "+91-9876543218",
        mothersName = "Rita Patel", mothersContact = "+91-8765432117",
        dateOfBirth = "22 Jan 2007", admissionDate = "17 Apr 2023",
        houseName = "Kunal", permanentAddress = "H.No. 45, C-26, Sector-12, Noida, Uttar Pradesh 201308",true
    ),
    StudentDetails(
        10, "Karan Singh", "+91-8873562256", R.drawable.avtar1, 82,
        email = "karan@example.com", className = "V-A", roleNumber = 10,
        fathersName = "Ajay Singh", fathersContact = "+91-9876543219",
        mothersName = "Nisha Singh", mothersContact = "+91-8765432118",
        dateOfBirth = "30 Feb 2007", admissionDate = "18 Apr 2023",
        houseName = "Rahul", permanentAddress = "H.No. 50, C-28, Sector-13, Noida, Uttar Pradesh 201309",true
    ),
    StudentDetails(
        11, "Priya Kapoor", "+91-8873562257", R.drawable.avtar1, 88,
        email = "priya@example.com", className = "V-A", roleNumber = 11,
        fathersName = "Sanjay Kapoor", fathersContact = "+91-9876543220",
        mothersName = "Anjali Kapoor", mothersContact = "+91-8765432119",
        dateOfBirth = "14 Apr 2006", admissionDate = "19 Apr 2023",
        houseName = "Siddhant", permanentAddress = "H.No. 55, C-30, Sector-14, Noida, Uttar Pradesh 201310",false
    ),
    StudentDetails(
        12, "Vivek Reddy", "+91-8873562258", R.drawable.avtar1, 76,
        email = "vivek@example.com", className = "V-A", roleNumber = 12,
        fathersName = "Ravi Reddy", fathersContact = "+91-9876543221",
        mothersName = "Lakshmi Reddy", mothersContact = "+91-8765432120",
        dateOfBirth = "09 Jun 2006", admissionDate = "20 Apr 2023",
        houseName = "Rohan", permanentAddress = "H.No. 60, C-32, Sector-15, Noida, Uttar Pradesh 201311",false
    ),
    StudentDetails(
        13, "Meera Joshi", "+91-8873562259", R.drawable.avtar1, 93,
        email = "meera@example.com", className = "V-A", roleNumber = 13,
        fathersName = "Anil Joshi", fathersContact = "+91-9876543222",
        mothersName = "Suman Joshi", mothersContact = "+91-8765432121",
        dateOfBirth = "03 Aug 2006", admissionDate = "21 Apr 2023",
        houseName = "Kiran", permanentAddress = "H.No. 65, C-34, Sector-16, Noida, Uttar Pradesh 201312",false
    ),
    StudentDetails(
        14, "Arjun Mehra", "+91-8873562260", R.drawable.avtar1, 79,
        email = "arjun@example.com", className = "V-A", roleNumber = 14,
        fathersName = "Vikram Mehra", fathersContact = "+91-9876543223",
        mothersName = "Neeta Mehra", mothersContact = "+91-8765432122",
        dateOfBirth = "17 Sep 2006", admissionDate = "22 Apr 2023",
        houseName = "Aman", permanentAddress = "H.No. 70, C-36, Sector-17, Noida, Uttar Pradesh 201313",true
    ),
    StudentDetails(
        15, "Shalini Gupta", "+91-8873562261", R.drawable.avtar1, 84,
        email = "shalini@example.com", className = "V-A", roleNumber = 15,
        fathersName = "Rakesh Gupta", fathersContact = "+91-9876543224",
        mothersName = "Poonam Gupta", mothersContact = "+91-8765432123",
        dateOfBirth = "22 Oct 2006", admissionDate = "23 Apr 2023",
        houseName = "Vishal", permanentAddress = "H.No. 75, C-38, Sector-18, Noida, Uttar Pradesh 201314",true
    ),
    StudentDetails(
        16, "Rohan Desai", "+91-8873562262", R.drawable.avtar1, 77,
        email = "rohan@example.com", className = "V-A", roleNumber = 16,
        fathersName = "Mahesh Desai", fathersContact = "+91-9876543225",
        mothersName = "Komal Desai", mothersContact = "+91-8765432124",
        dateOfBirth = "05 Nov 2006", admissionDate = "24 Apr 2023",
        houseName = "Prateek", permanentAddress = "H.No. 80, C-40, Sector-19, Noida, Uttar Pradesh 201315",true
    ),
    StudentDetails(
        17, "Tanya Malhotra", "+91-8873562263", R.drawable.avtar1, 90,
        email = "tanya@example.com", className = "V-A", roleNumber = 17,
        fathersName = "Sunil Malhotra", fathersContact = "+91-9876543226",
        mothersName = "Rita Malhotra", mothersContact = "+91-8765432125",
        dateOfBirth = "12 Dec 2006", admissionDate = "25 Apr 2023",
        houseName = "Suresh", permanentAddress = "H.No. 85, C-42, Sector-20, Noida, Uttar Pradesh 201316",true
    ),
    StudentDetails(
        18, "Kunal Sharma", "+91-8873562264", R.drawable.avtar1, 83,
        email = "kunal@example.com", className = "V-A", roleNumber = 18,
        fathersName = "Rajesh Sharma", fathersContact = "+91-9876543227",
        mothersName = "Anita Sharma", mothersContact = "+91-8765432126",
        dateOfBirth = "19 Jan 2007", admissionDate = "26 Apr 2023",
        houseName = "Gaurav", permanentAddress = "H.No. 90, C-44, Sector-21, Noida, Uttar Pradesh 201317",true
    ),
    StudentDetails(
        19, "Nisha Agarwal", "+91-8873562265", R.drawable.avtar1, 86,
        email = "nisha@example.com", className = "V-A", roleNumber = 19,
        fathersName = "Vijay Agarwal", fathersContact = "+91-9876543228",
        mothersName = "Meena Agarwal", mothersContact = "+91-8765432127",
        dateOfBirth = "25 Feb 2007", admissionDate = "27 Apr 2023",
        houseName = "Rakesh", permanentAddress = "H.No. 95, C-46, Sector-22, Noida, Uttar Pradesh 201318",true
    ),
    StudentDetails(
        20, "Samarth Jain", "+91-8873562266", R.drawable.avtar1, 81,
        email = "samarth@example.com", className = "V-A", roleNumber = 20,
        fathersName = "Amit Jain", fathersContact = "+91-9876543229",
        mothersName = "Pooja Jain", mothersContact = "+91-8765432128",
        dateOfBirth = "30 Mar 2007", admissionDate = "28 Apr 2023",
        houseName = "Nikhil", permanentAddress = "H.No. 100, C-48, Sector-23, Noida, Uttar Pradesh 201319",false
    )
)


val defaultPerformance = StudentPerformance(
    marks = listOf(
        ExamMark("UT-I", "50", "19"),
        ExamMark("UT-II", "50", "22"),
        ExamMark("Half Yearly", "100", "78"),
        ExamMark("UT-III", "50", "25"),
        ExamMark("UT-IV", "-", "-"),
        ExamMark("Practice Exam", "-", "-"),
        ExamMark("Final Year", "-", "-")
    ),
    grades = listOf("C", "A", "B1", "B", "-", "-", "-")
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



// -----------

