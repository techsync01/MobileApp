

package com.example.myapplication.uis.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.uis.components.BottomNavbar.CustomBottomBar
import com.example.myapplication.uis.components.Home.AbsentAvatarList
import com.example.myapplication.uis.components.Home.DashboardCard
import com.example.myapplication.uis.components.Home.EventCard
import com.example.myapplication.uis.components.Home.SectionTitle
import com.example.myapplication.uis.components.Home.TopBar
import com.example.myapplication.uis.model.Home.DashboardItem
import com.example.myapplication.uis.model.Home.EventItem

@Composable
fun DashboardScreen(navController: NavHostController) {
    val dashboardItems = listOf(
        DashboardItem("My Classes", Color(0xFF55D3B2), android.R.drawable.ic_menu_agenda),
        DashboardItem("Time Table", Color(0xFFA48CF6), android.R.drawable.ic_menu_month),
        DashboardItem("Attendance", Color(0xFF61C7F3), android.R.drawable.ic_menu_my_calendar),
        DashboardItem("Exams", Color(0xFFF583A5), android.R.drawable.ic_menu_edit),
        DashboardItem("Assignments", Color(0xFFFF8C47), android.R.drawable.ic_menu_manage),
        DashboardItem("Lesson Plan", Color(0xFFFFCC3B), android.R.drawable.ic_menu_info_details),
        DashboardItem("Dues", Color(0xFFFFCC3B), android.R.drawable.ic_menu_info_details),

    )

    val events = listOf(
        EventItem(
            title = "GK Quiz Contest 2025",
            description = "Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text.",
            date = "Mar 25",
            icon = R.drawable.ic_quiz
        ),
        EventItem(
            title = "School Function",
            description = "Short dummy content here.",
            date = "Mar 30",
            icon = R.drawable.ic_quiz
        )
    )

    val absentAvatars = listOf(
        R.drawable.avtar1,
        R.drawable.avtar1,
        R.drawable.avtar1
    )

    Scaffold(
        topBar = { TopBar() },
    ) { paddingValues ->

        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "My Space",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // Grid inside LazyColumn
            item {
                Column {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 0.dp, max = 900.dp), // 3 rows x ~200dp cards
                        userScrollEnabled = false,
                        contentPadding = PaddingValues(8.dp)
                    ) {
//                        items(dashboardItems) { item ->
//                            DashboardCard(item)
//                        }
                        items(dashboardItems) { item ->
                            DashboardCard(item) {
                                when (item.title) {
                                    "My Classes" -> navController.navigate("my_classes")
                                    "Time Table" -> navController.navigate("time_table")
                                    "Attendance" -> navController.navigate("attendance")
                                    "Exams" -> navController.navigate("exams")
                                    "Assignments" -> navController.navigate("assignments")
                                    "Lesson Plan" -> navController.navigate("lesson")
                                    "Dues" -> navController.navigate("dues")
                                }
                            }
                        }

                    }

                    // ✅ This spacer separates the last row from the Events section
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }


            item {
                SectionTitle(title = "Events")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(vertical = 8.dp)
                ) {
                    events.forEach {
                        EventCard(it)
                    }
                }
            }

            item {
                SectionTitle(title = "Absent Today")
                AbsentAvatarList(avatarList = absentAvatars)
                Spacer(modifier = Modifier.height(80.dp)) // Bottom nav spacing
            }
        }
    }
}
