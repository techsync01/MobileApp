//package com.example.myapplication
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import com.example.myapplication.ui.theme.MyApplicationTheme
//import com.example.myapplication.uis.components.BottomNavbar.CustomBottomBar
//import com.example.myapplication.uis.screens.*

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                var selectedIndex by remember { mutableStateOf(0) }
//
//                Scaffold(
//                    bottomBar = {
//                        CustomBottomBar(selectedIndex = selectedIndex) {
//                            selectedIndex = it
//                        }
//                    }
//                ) {  paddingValues ->
//                    Box(modifier = Modifier.padding(paddingValues)) {
//                        when (selectedIndex) {
//                            0 -> DashboardScreen()
//                            1 -> AchievementScreen()
//                            2 -> ChatScreen()
//                            3 -> SyllabusScreen()
//                            4 -> ProfileScreen()
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.AppNavGraph
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.uis.components.BottomNavbar.CustomBottomBar
import com.example.myapplication.uis.screens.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                var selectedIndex by remember { mutableStateOf(0) }
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        CustomBottomBar(selectedIndex = selectedIndex) {
                            selectedIndex = it
                            navController.navigate("main") // Reset to main when tab changes
                        }
                    }
                ) {  padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        AppNavGraph(
                            navController = navController,
                            selectedIndex = selectedIndex,
                            onIndexChange = { selectedIndex = it }
                        )
                    }
                }
            }
        }
    }
}
