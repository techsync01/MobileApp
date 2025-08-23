////package com.example.myapplication.uis.screens.HomeCard.Assignment

package com.example.myapplication.uis.screens.HomeCard.Assignment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Assignments.AssignmentTopBar
import com.example.myapplication.uis.components.Home.Card.Assignments.StudentSubmissionCard
import com.example.myapplication.uis.model.Home.Class.dummyStudents


@Composable
fun HomeInsideAssignmentDetailScreen(title: String, navController: NavController) {


    Scaffold(
        topBar = { AssignmentTopBar(title = title, onBackClick = { navController.popBackStack() }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            itemsIndexed(dummyStudents) { index, student ->
                StudentSubmissionCard(
                    student = student,
                )
            }
        }
    }
}
