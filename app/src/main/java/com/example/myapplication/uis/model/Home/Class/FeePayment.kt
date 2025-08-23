package com.example.myapplication.uis.model.Home.Class


import java.time.LocalDate
import java.time.LocalTime
import java.time.YearMonth


data class FeePayment(
    val id: String,
    val studentId: Int,
    val date: LocalDate,
    val time: LocalTime,
    val title: String,          // e.g., "May school fees"
    val amount: Int,            // in rupees
    val method: String,         // e.g., "UPI", "PhonePe"
    val remark: String? = null
)


object FeeRepository {

    // dummy, but stable per student id
    fun getPayments(studentId: Int): List<FeePayment> {
        val ym = YearMonth.of(2025, 5)
        return listOf(
            FeePayment(
                id = "1",
                studentId = studentId,
                date = LocalDate.of(2025, 8, 2),
                time = LocalTime.of(13, 20),
                title = "May school fees",
                amount = 5500,
                method = "UPI",
                remark = "May school fees"
            ),
            FeePayment(
                id = "2",
                studentId = studentId,
                date = LocalDate.of(2025, 8, 8),
                time = LocalTime.of(10, 42),
                title = "Sports Activity fees",
                amount = 1200,
                method = "PhonePe",
                remark = "Sports Activity fees"
            ),
            FeePayment(
                id = "3",
                studentId = studentId,
                date = LocalDate.of(2025, 8, 12),
                time = LocalTime.of(14, 55),
                title = "No Remarks",
                amount = 300,
                method = "PhonePe",
                remark = "No Remarks"
            )
        )
    }
}

