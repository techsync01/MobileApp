package com.example.myapplication.uis.screens.HomeCard.Assignment



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Assignments.AssignmentCard
import com.example.myapplication.uis.components.Home.Card.Assignments.AssignmentTopBar
import com.example.myapplication.uis.components.Home.Card.Assignments.HomeInsideAssignmentCard
import com.example.myapplication.uis.model.Home.Assignments.Assignment
import com.example.myapplication.uis.model.Home.Assignments.InsideHomeAssignments
import com.example.myapplication.uis.model.Home.Assignments.dummyAssignments
import com.example.myapplication.uis.model.Home.Assignments.dummyInsideHomeAssignments

@Composable
fun AssignmentDetailScreen(className: String,navController: NavController) {
    Scaffold(
        topBar = { AssignmentTopBar(title = className, onBackClick = { navController.popBackStack() }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add new assignment */ }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
            items(dummyInsideHomeAssignments) { assignment: InsideHomeAssignments ->
                HomeInsideAssignmentCard (assignment) {
                    navController.navigate("home_inside_assignment_detail/${assignment.title}")
                }
            }
        }
    }
}

