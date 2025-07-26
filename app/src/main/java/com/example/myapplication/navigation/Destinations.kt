package com.example.myapplication.navigation

sealed class Destinations(val route: String) {
    object Leaderboard : Destinations("leaderboard")
    object StudentDetails : Destinations("studentDetails/{studentId}") {
        fun create(studentId: Int) = "studentDetails/$studentId"
    }

    // Feature routes (studentId is kept to fetch student-specific data if needed later)
    object Performance : Destinations("student/{studentId}/performance")
    object Attendance : Destinations("student/{studentId}/attendance")
    object Information : Destinations("student/{studentId}/information")
    object FeeDetails : Destinations("student/{studentId}/feeDetails")
    object Participations : Destinations("student/{studentId}/participations")
    object Assignments : Destinations("student/{studentId}/assignments")
    object ChatWithParents : Destinations("student/{studentId}/chatWithParents")
    object ChatWithStudent : Destinations("student/{studentId}/chatWithStudent")
}
