//
//
//package com.example.myapplication.uis.components.Achievement
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun SessionReportChart(
//    percentages: List<Int>,
//    language: String = "English"
//) {
//    Column(modifier = Modifier.fillMaxWidth()) {
//
//        // Title & Language tag row
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "Session-Wise Report",
//                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
//            )
//            Box(
//                modifier = Modifier
//                    .background(Color(0xFFF0EFFF), shape = RoundedCornerShape(8.dp))
//                    .padding(horizontal = 12.dp, vertical = 4.dp)
//            ) {
//                Text(
//                    text = language,
//                    color = Color(0xFF7C4DFF),
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        // Graph bars
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp), // taller like screenshot
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.Bottom
//        ) {
//            percentages.forEachIndexed { index, percent ->
//                val year = "20${21 + index}–${22 + index}"
//
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Bottom
//                ) {
//                    // Gray background bar
//                    Box(
//                        modifier = Modifier
//                            .height(140.dp)
//                            .width(12.dp) // thinner bar
//                            .clip(RoundedCornerShape(6.dp))
//                            .background(Color(0xFFEAEAEA)),
//                        contentAlignment = Alignment.BottomCenter
//                    ) {
//                        // Foreground (purple) percentage bar
//                        Box(
//                            modifier = Modifier
//                                .height((percent * 1.4).dp) // scaled to match screenshot
//                                .width(12.dp)
//                                .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
//                                .background(Color(0xFF7C4DFF))
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.height(6.dp))
//
//                    Text(
//                        text = year,
//                        style = MaterialTheme.typography.bodySmall
//                    )
//                }
//            }
//        }
//    }
//}



package com.example.myapplication.uis.components.Achievement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SessionReportChart(
    percentages: List<Int>,
    language: String = "English"
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Title & Language tag row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Session-Wise Report",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFFF0EFFF), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = language,
                        color = Color(0xFF7C4DFF),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bar Chart Area
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                percentages.forEachIndexed { index, percent ->
                    val year = "20${21 + index}–${22 + index}"

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        // Background bar
                        Box(
                            modifier = Modifier
                                .height(180.dp)
                                .width(10.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFEAEAEA)),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            // Foreground bar (value bar)
                            Box(
                                modifier = Modifier
                                    .height((percent * 1.8).dp)
                                    .width(10.dp)
                                    .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                                    .background(Color(0xFF7C4DFF))
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = year,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}