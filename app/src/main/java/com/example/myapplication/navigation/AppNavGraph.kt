
package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.uis.model.Edit.UserProfile
import com.example.myapplication.uis.screens.AchievementScreen
import com.example.myapplication.uis.screens.AttendanceScreen
import com.example.myapplication.uis.screens.ChatDetailScreen
import com.example.myapplication.uis.screens.ChatScreen
import com.example.myapplication.uis.screens.Class.ClassDetailScreen
import com.example.myapplication.uis.screens.Class.LeaderboardScreen
import com.example.myapplication.uis.screens.Class.MyClassesScreen
import com.example.myapplication.uis.screens.Class.StudentDetailsScreen
import com.example.myapplication.uis.screens.Class.features.StudentInformationScreen
import com.example.myapplication.uis.screens.DashboardScreen
import com.example.myapplication.uis.screens.DuesScreen
import com.example.myapplication.uis.screens.ProfileEditScreen
import com.example.myapplication.uis.screens.ProfileScreen
import com.example.myapplication.uis.screens.StudentFeeDetailsScreen
import com.example.myapplication.uis.screens.SyllabusScreen
import com.example.myapplication.uis.screens.student.features.PerformanceScreen
import com.example.myapplication.uis.screens.*
import com.example.myapplication.uis.screens.Class.features.AssignmentsScreen
import com.example.myapplication.uis.screens.Class.features.FeeDetailsScreen
import com.example.myapplication.uis.screens.Class.features.ParentChatScreen
import com.example.myapplication.uis.screens.Class.features.ParticipationScreen


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
            ProfileEditScreen (
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
        ) {
            AttendanceScreen(onBack = { navController.popBackStack() })
        }

        composable(
            route = "student/{studentId}/information",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            StudentInformationScreen(navController = navController, studentId = studentId)
        }

        composable(
            route = "student/{studentId}/feeDetails",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            FeeDetailsScreen (
                studentId = studentId,
                onBack = { navController.popBackStack() }
            )
        }


        composable(
            route = "student/{studentId}/participations",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) {
            ParticipationScreen (onBack = { navController.popBackStack() })
        }

        composable(
            route = "student/{studentId}/assignments",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) {backStackEntry->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            AssignmentsScreen(studentId = studentId, onBack = { navController.popBackStack() })
        }


        composable(
            route = "student/{studentId}/chatWithParents",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) {backStackEntry->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            ParentChatScreen(studentId = studentId, onBack = { navController.popBackStack() })
        }


        composable(
            route = "student/{studentId}/chatWithStudent",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            ParentChatScreen(studentId = studentId, onBack = { navController.popBackStack() })
        }

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

        composable("lesson"){
            LessonScreen(navController)
        }

        composable("dues") {
            DuesScreen(navController)
        }
    }
}
