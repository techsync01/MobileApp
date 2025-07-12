package com.example.myapplication.uis.screens.Class

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.LeaderBorad.CircularProgressWithLabel
import com.example.myapplication.uis.model.Home.Class.dummyStudents
import com.example.myapplication.uis.screens.Purple500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDetailScreen(studentId: Int, navController: NavController) {
    val student = remember {
        dummyStudents.find { it.id == studentId } ?: dummyStudents.first()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(student.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(student.image),
                contentDescription = "Student Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.height(12.dp))
            Text(text = student.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = student.phone, color = Color.Gray)
            Spacer(Modifier.height(20.dp))

            Text("Performance by Subject", fontWeight = FontWeight.SemiBold)

            val subjects = listOf(
                "Maths" to 92,
                "Science" to 88,
                "English" to 95,
                "Social Studies" to 85,
                "Hindi" to 89
            )

            Spacer(Modifier.height(12.dp))
            subjects.forEach { (subject, mark) ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(subject)
                    CircularProgressWithLabel(score = mark, total = 100, color = Purple500)
                }
            }
        }
    }
}
