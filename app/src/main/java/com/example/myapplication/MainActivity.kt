

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
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

                // Get the current route
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        // Show bottom bar only for the main route
                        if (currentRoute == "main") {
                            CustomBottomBar(selectedIndex = selectedIndex) {
                                selectedIndex = it
                                navController.navigate("main") // Reset to main when tab changes
                            }
                        }
                    }
                ) { padding ->
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


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContent {
//            MyApplicationTheme {
//                var selectedIndex by remember { mutableStateOf(0) }
//                val navController = rememberNavController()
//
//                Scaffold(
//                    bottomBar = {
//                        CustomBottomBar(selectedIndex = selectedIndex) {
//                            selectedIndex = it
//                            navController.navigate("main") // Reset to main when tab changes
//                        }
//                    }
//                ) {  padding ->
//                    Box(modifier = Modifier.padding(padding)) {
//                        AppNavGraph(
//                            navController = navController,
//                            selectedIndex = selectedIndex,
//                            onIndexChange = { selectedIndex = it }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
