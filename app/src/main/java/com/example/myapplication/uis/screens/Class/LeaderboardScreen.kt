package com.example.myapplication.uis.screens.Class

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.LeaderBorad.PodiumView
import com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.LeaderBorad.StudentCard
import com.example.myapplication.uis.model.Home.Class.StudentDetails
import com.example.myapplication.uis.model.Home.Class.dummyStudents
import com.example.myapplication.uis.screens.Purple500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen(navController: NavController) {
    val students = remember {
        dummyStudents.sortedByDescending { it.percentage } // Ensure ranking
    }

    Box(modifier = Modifier.fillMaxSize().background(Purple500)) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Fixed Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "My Class",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                    )
                    Spacer(modifier = Modifier.size(48.dp)) // Balance IconButton
                }

                PodiumView(topThree = students.take(3))
                Text(
                    "Class Toppers So Far (UT-1+UT-2+HY)",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            // Scrollable White List
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color.White)
            ) {
                LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                    itemsIndexed(students) { index, student ->
                        StudentCard(
                            rank = index + 1,
                            student = student,
                            onClick = {
                                navController.navigate("studentDetail/${student.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}

