//package com.example.myapplication.uis.screens.HomeCard.Dues
//
package com.example.myapplication.uis.screens.HomeCard.Dues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Dues.StudentCard
import com.example.myapplication.uis.model.Home.Class.dummyStudents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(navController: NavController, className: String) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F5FF)) // light purple bg
    ) {
        // 🔹 Top Purple Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF7C4DFF)) // Purple
                .padding(vertical = 16.dp, horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Text(
                    text = "Students List",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(48.dp)) // to balance layout
            }
        }

        // 🔹 Month Selector with Arrows
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF7C4DFF))
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("May 2025", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

            Row {
                IconButton(onClick = { /* prev month */ }) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Prev", tint = Color.White)
                }
                IconButton(onClick = { /* next month */ }) {
                    Icon(Icons.Default.ArrowForwardIos, contentDescription = "Next", tint = Color.White)
                }
            }
        }

        // 🔹 Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search students") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )

        // 🔹 Student List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(dummyStudents) { student ->
                StudentCard(student) {
                    navController.navigate("dues_student_details/${student.id}")
                }
            }
        }
    }
}

//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.myapplication.uis.components.Home.Card.Dues.StudentCard
//import com.example.myapplication.uis.model.Home.Class.dummyStudents
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun StudentListScreen(navController: NavController, className: String) {
//    var searchQuery by remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(   // ✅ instead of SmallTopAppBar
//                title = { Text("Students List") },
//                navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { /* TODO: open search */ }) {
//                        Icon(Icons.Default.Search, contentDescription = "Search")
//                    }
//                }
//            )
//        }
//    ) { padding ->
//        LazyColumn(modifier = Modifier.padding(padding)) {
//            items(dummyStudents) { student ->
//                StudentCard (student) {
//                    navController.navigate("student_details/${student.id}")
//                }
//            }
//        }
//    }
//}
