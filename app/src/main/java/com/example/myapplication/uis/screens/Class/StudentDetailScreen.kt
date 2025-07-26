package com.example.myapplication.uis.screens.Class



import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.FeatureCard
import com.example.myapplication.uis.model.Home.Class.dummyStudents
import com.example.myapplication.uis.model.Home.Class.featureCards

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun StudentDetailsScreen(
    studentId: Int,
    navController: NavController
) {
    val student = dummyStudents.find { it.id == studentId }
    val studentName = student?.name ?: "Student"
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(studentName) }, // replace with selected student's name if you fetch it
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = { /* your BottomNavBar if you use it */ },
        containerColor = Color(0xFFF6F7FC)
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            content = {
                items(featureCards) { feature ->
                    FeatureCard (
                        title = feature.title,
                        icon = feature.icon,
                        containerColor = feature.color
                    ) {
                        navController.navigate(feature.routeBuilder(studentId))
                    }
                }
            }
        )
    }
}
