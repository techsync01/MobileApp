package com.example.myapplication.uis.model.Home.Class


import androidx.annotation.DrawableRes
import java.time.LocalDate
import com.example.myapplication.R


data class ActivityItem(
    val title: String,
    val description: String,
    val startDate: LocalDate,
    val endDate: LocalDate? = null, // For events with a range
    @DrawableRes val iconRes: Int,
    val participants: List<Int> // Drawable resource IDs for avatars
)




object ActivityRepository {
    fun getActivities(): List<ActivityItem> {
        return listOf(
            ActivityItem(
                title = "Vollyball Tournament",
                description = "The tournament will held from may 22 to may 26 in JLN stadium, New Delhi.",
                startDate = LocalDate.of(2025, 5, 22),
                endDate = LocalDate.of(2025, 5, 26),
                iconRes = R.drawable.avtar1, // Add icon in drawable
                participants = listOf(
                    R.drawable.avtar1,
                    R.drawable.avtar1,
                    R.drawable.avtar1
                )
            ),
            ActivityItem(
                title = "Annual Day Preparations",
                description = "The school annual day program will be held on may 31, 2025, from 5 PM onwards.",
                startDate = LocalDate.of(2025, 5, 31),
                iconRes = R.drawable.avtar1, // Add icon in drawable
                participants = listOf(
                    R.drawable.avtar1,
                    R.drawable.avtar1,
                    R.drawable.avtar1
                )
            )
        )
    }
}
