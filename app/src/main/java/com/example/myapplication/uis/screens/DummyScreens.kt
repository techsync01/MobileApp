package com.example.myapplication.uis.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavHostController

//@OptIn(ExperimentalMaterial3Api::class)

//import androidx.compose.ui.unit.PaddingValues

//@Composable
//fun AchievementsScreen(paddingValues: PaddingValues) {
//    CenteredTextScreen("Achievements", paddingValues)
//}

//@Composable
//fun ChatScreen() {
//    CenteredTextScreen("Chat")
//}

//@Composable
//fun DocsScreen(paddingValues: PaddingValues) {
//    CenteredTextScreen("Docs", paddingValues)
//}

//@Composable
//fun ProfileScreen(paddingValues: PaddingValues) {
//    CenteredTextScreen("Profile", paddingValues)
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyClassesScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Classes") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("My Classes", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("- Class 1: Mathematics")
            Text("- Class 2: Science")
            Text("- Class 3: History")
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//
//@Composable
//fun TimeTableScreen(navController: NavHostController) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Time Table") },
//                navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        }
//    ) { padding ->
//        Text("This is Time Table Screen", modifier = Modifier.padding(padding))
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Attendance") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Attendance", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Present: 22")
            Text("Absent: 3")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exams") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Exams", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Math Exam: June 30")
            Text("Science Exam: July 5")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssignmentsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Assignments") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Assignments", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Math HW: Due June 25")
            Text("English Essay: Due June 28")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DuesScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dues") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Dues", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Library Fine: Rs. 200")
            Text("Tuition Due: Rs. 1500")
        }
    }
}





@Composable
fun CenteredTextScreen(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F6FB)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7C4DFF)
        )
    }
}
