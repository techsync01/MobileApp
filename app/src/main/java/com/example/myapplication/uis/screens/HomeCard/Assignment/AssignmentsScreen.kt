package com.example.myapplication.uis.screens.HomeCard.Assignment


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Assignments.AssignmentCard
import com.example.myapplication.uis.components.Home.Card.Assignments.AssignmentTopBar
import com.example.myapplication.uis.model.Home.Assignments.Assignment
import com.example.myapplication.uis.model.Home.Assignments.dummyAssignments


@Composable
fun HomeAssignmentsScreen(navController: NavController) {
    Scaffold(
        topBar = { AssignmentTopBar (onBackClick = { navController.popBackStack() }) }
    ) { padding ->
        Column(modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(padding)) {
            LazyColumn {
                items(dummyAssignments) { assignment: Assignment ->
                    AssignmentCard (assignment) {
                        navController.navigate("assignment_detail/${assignment.className}")
                    }
                }
            }
        }
    }
}
