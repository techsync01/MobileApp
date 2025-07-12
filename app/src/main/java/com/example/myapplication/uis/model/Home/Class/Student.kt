package com.example.myapplication.uis.model.Home.Class

import androidx.compose.ui.graphics.Color
import com.example.myapplication.R


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


fun getRankColor(rank: Int): Color {
    val colors = listOf(
        Color(0xFF8B5CF6),
        Color(0xFF6C63FF),
        Color(0xFFE63946),
        Color(0xFFB39DDB)
    )
    return colors[(rank - 1) % colors.size]
}


