
package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.uis.model.Edit.UserProfile
import com.example.myapplication.uis.screens.*
import com.example.myapplication.uis.screens.Class.*
import com.example.myapplication.uis.screens.student.features.PerformanceScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    selectedIndex: Int,
    onIndexChange: (Int) -> Unit
) {
    val user = UserProfile(
        name = "Lavanya Pathak",
        email = "pathaklav12@gmail.com",
        phone = "+91-9875352416",
        className = "V-A",
        subject = "English"
    )

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {

        // ---------------------- BOTTOM NAV CONTAINER ----------------------
        composable("main") {
            when (selectedIndex) {
                0 -> DashboardScreen(navController)
                1 -> AchievementScreen()
                2 -> ChatScreen(onChatClick = { chatId ->
                    navController.navigate("chat_detail/$chatId")
                })
                3 -> SyllabusScreen()
                4 -> ProfileScreen(
                    onEditClick = { navController.navigate("edit_profile") }
                )
            }
        }

        // ---------------------- PROFILE ----------------------
        composable("edit_profile") {
            ProfileEditScreen(
                user = user,
                onBackClick = { navController.popBackStack() },
                onEditClick = { /* Save logic */ },
                onChangePasswordClick = { /* TODO */ }
            )
        }

        // ---------------------- CHAT ----------------------
        composable(
            route = "chat_detail/{chatId}",
            arguments = listOf(navArgument("chatId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            ChatDetailScreen(chatId = chatId, onBackClick = { navController.popBackStack() })
        }

        // ---------------------- CLASSES ----------------------
        composable("my_classes") {
            MyClassesScreen(navController)
        }

        composable(
            route = "class_detail/{className}",
            arguments = listOf(navArgument("className") { type = NavType.StringType })
        ) { backStackEntry ->
            val className = backStackEntry.arguments?.getString("className") ?: ""
            ClassDetailScreen(title = className, nav = navController)
        }

        // ---------------------- LEADERBOARD → STUDENT DETAILS ----------------------
        // From ClassDetail -> Student list (Leaderboard)
        composable(
            route = "student_screen/{className}",
            arguments = listOf(navArgument("className") { type = NavType.StringType })
        ) {
            LeaderboardScreen(navController = navController)
        }

        // Student detail grid (8 feature cards)
        composable(
            route = "studentDetail/{studentId}",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            StudentDetailsScreen(studentId, navController)
        }

        // ---------------------- STUDENT FEATURE SCREENS (Dummy) ----------------------
        // NOTE: All feature routes are namespaced with studentId so you can use it later.

        composable(
            "student/{studentId}/performance",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            PerformanceScreen(
                studentId = studentId,
                navController = navController
            )
        }

        composable(
            route = "student/{studentId}/attendance",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { StudentAttendanceScreen(navController) }

        composable(
            route = "student/{studentId}/information",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { StudentInformationScreen(navController) }

        composable(
            route = "student/{studentId}/feeDetails",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { StudentFeeDetailsScreen(navController) }

        composable(
            route = "student/{studentId}/participations",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { StudentParticipationsScreen(navController) }

        composable(
            route = "student/{studentId}/assignments",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { AssignmentsScreen(navController) }

        composable(
            route = "student/{studentId}/chatWithParents",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { ChatWithParentsScreen(navController) }

        composable(
            route = "student/{studentId}/chatWithStudent",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { ChatWithStudentScreen(navController) }

        // ---------------------- OTHER (already in your app) ----------------------
        composable("time_table") {
            TimeTableScreen(onBack = { navController.popBackStack() })
        }

        composable("attendance") {
            AttendanceScreen(onBack = { navController.popBackStack() })
        }

        composable("exams") {
            ExamsScreen(navController)
        }

        composable("assignments") {
            AssignmentsScreen(navController)
        }

        composable("dues") {
            DuesScreen(navController)
        }
    }
}
