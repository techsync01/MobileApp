package com.example.myapplication.uis.screens.HomeCard.Dues


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Card.Dues.DuesCard
import com.example.myapplication.uis.components.Home.Card.Dues.TopBar

@Composable
fun DuesScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar("Dues", navController) }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding).padding(8.dp)
        ) {
            items(
                listOf(
                    Triple("V", "Section-A", 86),
                    Triple("V", "Section-B", 89),
                    Triple("VII", "Section-A", 91),
                    Triple("IX", "Section-B", 82)
                )
            ) { (className, section, percent) ->
                DuesCard (className, section, percent, Color(0xFF7C4DFF)) {
                    navController.navigate("dues_student_list/$className")
                }
            }
        }
    }
}
