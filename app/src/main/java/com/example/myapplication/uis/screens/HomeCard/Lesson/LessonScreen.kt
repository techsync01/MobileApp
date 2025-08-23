package com.example.myapplication.uis.screens.HomeCard.Lesson


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.LessonPlan.DateRangeSelector
import com.example.myapplication.uis.components.Home.Card.LessonPlan.LessonPlanCard
import com.example.myapplication.uis.components.Home.Card.LessonPlan.LessonPlanTopBar
import com.example.myapplication.uis.model.Home.Cards.LessonPlan.DummyLessonPlans

@Composable
fun LessonScreen(navController: NavController) {
    Scaffold(
        topBar = { LessonPlanTopBar { navController.popBackStack() } },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_lesson") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Lesson")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
//            DateRangeSelector()
            DateRangeSelector(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                onSearch = { from, to ->
                    // Handle search/filter here
                }
            )
            Spacer(modifier = Modifier.height(1.dp))

            LazyColumn {
                items(DummyLessonPlans.lessons) { lesson ->
                    LessonPlanCard(lesson)
                }
            }
        }
    }
}
