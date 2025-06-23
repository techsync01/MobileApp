package com.example.myapplication.uis.screens



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.uis.components.*
import com.example.myapplication.uis.components.Achievement.AchievementHeader
import com.example.myapplication.uis.components.Achievement.ClassTabs
import com.example.myapplication.uis.components.Achievement.LeaderBoardCardList
import com.example.myapplication.uis.components.Achievement.LovedByStudentCard
import com.example.myapplication.uis.components.Achievement.SessionReportChart
import com.example.myapplication.uis.model.*
import com.example.myapplication.uis.model.Achievement.AchievementItem
import com.example.myapplication.uis.model.Achievement.LovedCardItem

@Composable
fun AchievementScreen() {
    var selectedTab by remember { mutableStateOf("Class V") }
    val scrollState = rememberScrollState()

    val stats = listOf(
        AchievementItem("4", "Session Completed", R.drawable.ic_quiz),
        AchievementItem("64", "Live Class Conducted", R.drawable.ic_quiz),
        AchievementItem("81%", "Overall Result\nEnglish | 2024–25", R.drawable.ic_quiz),
        AchievementItem("91%", "Liked By Students", R.drawable.ic_quiz)
    )

    val reportData = mapOf(
        "Class V" to listOf(78, 66, 74, 77),
        "Class VI" to listOf(70, 80, 85, 88),
        "Class VII" to listOf(55, 60, 65, 70)
    )

    val lovedByStudents = List(5) {
        LovedCardItem("Student ${it + 1}", "Appreciated your teaching style")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AchievementHeader()

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            LeaderBoardCardList(stats)

            Spacer(modifier = Modifier.height(16.dp))

            ClassTabs (
                tabs = listOf("Class V", "Class VI", "Class VII"),
                selected = selectedTab,
                onTabSelected = { selectedTab = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SessionReportChart(reportData[selectedTab] ?: emptyList())

            Spacer(modifier = Modifier.height(16.dp))

            Text("Loved by your students?", style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow {
                items(lovedByStudents.size) {
                    LovedByStudentCard(lovedByStudents[it])
                }
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}
