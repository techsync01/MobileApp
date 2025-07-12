package com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.LeaderBorad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.model.Home.Class.StudentDetails




@Composable
fun PodiumView(topThree: List<StudentDetails>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        // Order: 2nd - 1st - 3rd
        PodiumStep(rank = 2, student = topThree.getOrNull(1), height = 100.dp)
        PodiumStep(rank = 1, student = topThree.getOrNull(0), height = 130.dp)
        PodiumStep(rank = 3, student = topThree.getOrNull(2), height = 80.dp)
    }
}


@Composable
fun PodiumStep(rank: Int, student: StudentDetails?, height: Dp) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Image and name label above podium
        student?.let {
            Spacer(Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFF6D47D9)) // Purple pill
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = it.name,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.height(8.dp))

            Image(
                painter = painterResource(id = it.image),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = "${it.percentage}%",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Spacer(Modifier.height(10.dp))

        // Podium Block
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(height)
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF9C6BFD),
                            Color(0xFF8150FF)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = rank.toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}
