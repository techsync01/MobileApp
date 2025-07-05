package com.example.myapplication.uis.screens.Class


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.uis.components.Home.Card.Class.ClassCard
import com.example.myapplication.uis.model.Home.Class.ClassItem

//import com.example.myapplication.uis.components.classes.ClassCard
//import com.example.myapplication.uis.model.Home.ClassItem

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun MyClassesScreen(navController: NavController) {
    val classItems = listOf(
        ClassItem("V-A", "Lavanya Pathak", R.drawable.avtar1, 0.73f, 29, 35, Color(0xFF7C4DFF)),
        ClassItem("VI-B", "Minakshi Khanna", R.drawable.avtar1, 0.94f, 32, 41, Color(0xFFFF7043)),
        ClassItem("V-A", "Lavanya Pathak", R.drawable.avtar1, 0.73f, 29, 35, Color(0xFF42A5F5)),
        ClassItem("VI-B", "Minakshi Khanna", R.drawable.avtar1, 0.94f, 32, 41, Color(0xFFFFC107)),
        ClassItem("V-A", "Lavanya Pathak", R.drawable.avtar1, 0.73f, 29, 35, Color(0xFF7C4DFF)),
        ClassItem("VI-B", "Minakshi Khanna", R.drawable.avtar1, 0.94f, 32, 41, Color(0xFFFF7043)),
        ClassItem("V-A", "Lavanya Pathak", R.drawable.avtar1, 0.73f, 29, 35, Color(0xFF42A5F5)),
        ClassItem("VI-B", "Minakshi Khanna", R.drawable.avtar1, 0.94f, 32, 41, Color(0xFFFFC107)),

        )

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
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(classItems.size) { index ->
                ClassCard(item = classItems[index]) {
                    navController.navigate("class_detail/${classItems[index].title}")
                }
            }
        }
    }
}


//@Composable
//fun MyClassesScreen(navController: NavController) {
//    val classes = listOf(
//        // create four items based on image reference
//        ClassItem("V-A", "Lavanya Pathak", R.drawable.avtar1, 0.73f, 29, 35, Color(0xFF7C4DFF)),
//        ClassItem("VI‑B", "Minakshi Khanna", R.drawable.avtar1, 0.94f, 32, 41, Color(0xFFFF7043)),
//        ClassItem("V-C", "Amit Sharma", R.drawable.avtar1, 0.85f, 28, 33, Color(0xFF42A5F5)),
//        ClassItem("VII‑A", "Sunita Rao", R.drawable.avtar1, 0.67f, 20, 30, Color(0xFFFFC107))
//    )
//    Scaffold(topBar = {
//        TopAppBar(
//            title = { Text("My Classes") },
//            navigationIcon = {
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                }
//            }
//        )
//    }) { padding ->
//        LazyColumn(modifier = Modifier.padding(padding)) {
//            items(classes.size) { index ->
//                ClassCard(item = classes[index]) {
//                    navController.navigate("class_detail/${classes[index].title}")
//                }
//            }
//        }
//    }
//}
