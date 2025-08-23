package com.example.myapplication.uis.model.Home.Assignments


data class Assignment(
    val id: Int,
    val className: String,
    val section: String,
    val avatars: List<Int>,   // resource ids
    val moreCount: Int,
    val lastPublished: String,
    val bgColor: Long         // store hex color
)

val dummyAssignments = listOf(
    Assignment(
        id = 1,
        className = "V",
        section = "Section-A",
        avatars = listOf(
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1
        ),
        moreCount = 32,
        lastPublished = "12 July 2025",
        bgColor = 0xFF55D3B2
    ),
    Assignment(
        id = 2,
        className = "VII",
        section = "Section-A",
        avatars = listOf(
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1
        ),
        moreCount = 32,
        lastPublished = "12 July 2025",
        bgColor = 0xFFA48CF6
    ),
    Assignment(
        id = 3,
        className = "VIII",
        section = "Section-A",
        avatars = listOf(
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1
        ),
        moreCount = 32,
        lastPublished = "12 July 2025",
        bgColor = 0xFF61C7F3
    ),
    Assignment(
        id = 4,
        className = "IX",
        section = "Section-A",
        avatars = listOf(
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1,
            com.example.myapplication.R.drawable.avtar1
        ),
        moreCount = 32,
        lastPublished = "12 July 2025",
        bgColor = 0xFFF583A5
    )
)



data class InsideHomeAssignments(
    val subject: String,
    val title: String,
    val deadline: String,
    val date: String,
    val progress: Int,
    val className: String
)


val dummyInsideHomeAssignments = listOf(
    InsideHomeAssignments(
        subject = "Mathematics",
        title = "Introduction to Pythagorean theorem",
        deadline = "1 Week",
        date = "19 July 2025",
        progress = 73,
        className = "V-A"
    ),
    InsideHomeAssignments(
        subject = "Science",
        title = "Chemical reaction and their important parameters",
        deadline = "1 Week",
        date = "19 July 2025",
        progress = 73,
        className = "V-A"
    )
)

