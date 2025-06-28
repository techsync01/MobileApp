package com.example.myapplication.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.uis.model.Edit.UserProfile
import com.example.myapplication.uis.screens.*

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
                0 -> DashboardScreen()
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

    }
}
