

package com.example.myapplication.navigation

//import ClassDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.uis.model.Edit.UserProfile
import com.example.myapplication.uis.screens.*
import com.example.myapplication.uis.screens.Class.*

@Composable
fun AppNavGraph(
    navController: NavHostController,
    selectedIndex: Int,
    onIndexChange: (Int) -> Unit
) {
    val user = UserProfile("Lavanya Pathak", "pathaklav12@gmail.com", "+91-9875352416", "V-A", "English")

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
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

        composable("edit_profile") {
            ProfileEditScreen(
                user = user,
                onBackClick = { navController.popBackStack() },
                onEditClick = { /* Save logic */ },
                onChangePasswordClick = { /* TODO */ }
            )
        }

        composable("chat_detail/{chatId}") { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            ChatDetailScreen(chatId = chatId, onBackClick = { navController.popBackStack() })
        }

        // 🚀 Navigates from Dashboard -> My Classes
        composable("my_classes") {
            MyClassesScreen(navController)
        }

        // 🚀 Navigates from My Classes -> Class Detail
        composable("class_detail/{className}") { backStackEntry ->
            val className = backStackEntry.arguments?.getString("className") ?: ""
            ClassDetailScreen(title = className, nav = navController)
        }

        // 🚀 Navigates from Class Detail -> Student Detail
//        composable("student_screen/{className}") { backStackEntry ->
//            val className = backStackEntry.arguments?.getString("className") ?: ""
//            StudentDetailScreen( nav = navController)
//        }
        composable("student_screen/{className}") { backStackEntry ->
            val className = backStackEntry.arguments?.getString("className") ?: ""
            LeaderboardScreen( navController = navController)
        }
        composable("studentDetail/{studentId}",
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            StudentDetailScreen(studentId, navController)
        }


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
