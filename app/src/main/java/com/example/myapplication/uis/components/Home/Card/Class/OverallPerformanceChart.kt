package com.example.myapplication.uis.components.Home.Card.Class

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OverallPerformanceChart() {
    Card(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Overall Performance", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp) // height applied to align all bars
            ) {
                listOf(
                    "UT‑I" to 0.75f,
                    "UT‑II" to 0.60f,
                    "HY" to 0.70f,
                    "UT‑III" to 0.80f
                ).forEach { (label, pct) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(12.dp)
                                .weight(1f),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                // Background bar
                                drawRect(color = Color.LightGray)
                                // Foreground bar (score)
                                drawRect(
                                    color = Color(0xFF7C4DFF),
                                    topLeft = androidx.compose.ui.geometry.Offset(0f, size.height * (1 - pct)),
                                    size = Size(size.width, size.height * pct)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(label, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}
