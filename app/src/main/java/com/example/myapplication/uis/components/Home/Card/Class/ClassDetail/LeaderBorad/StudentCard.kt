package com.example.myapplication.uis.components.Home.Card.Class.ClassDetail.LeaderBorad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Purple
import com.example.myapplication.uis.model.Home.Class.StudentDetails
import com.example.myapplication.uis.model.Home.Class.getRankColor
import com.example.myapplication.uis.screens.Purple500

//@Composable
//fun StudentCard(rank: Int, student: StudentDetails, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 12.dp, vertical = 6.dp)
//            .clickable { onClick() },
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(4.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Rank Badge
//            Text(
//                text = rank.toString().padStart(2, '0'),
//                color = Color.White,
//                fontSize = 14.sp,
//                modifier = Modifier
//                    .background(Purple500, shape = RoundedCornerShape(6.dp))
//                    .padding(horizontal = 8.dp, vertical = 4.dp)
//            )
//
//            Spacer(Modifier.width(12.dp))
//
//            // Student Image
//            Image(
//                painter = painterResource(student.image),
//                contentDescription = "Student Image",
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//            )
//
//            Spacer(Modifier.width(12.dp))
//
//            // Student Details
//            Column(Modifier.weight(1f)) {
//                Text(
//                    text = student.name,
//                    style = MaterialTheme.typography.bodyLarge,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = student.phone,
//                    style = MaterialTheme.typography.bodySmall,
//                    color = Color.Gray
//                )
//            }
//
//            // Circular Progress (Score)
//            CircularProgressWithLabel(score = student.percentage, total = 100, color = Purple500)
//        }
//    }
//}



@Composable
fun StudentCard(rank: Int, student: StudentDetails, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(56.dp)) {
                Image(
                    painter = painterResource(student.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                )

                // Rank badge overlay on avatar
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = (-4).dp, y = 4.dp)
                        .background(
                            color = getRankColor(rank),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = rank.toString().padStart(2, '0'),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(student.name, fontWeight = FontWeight.Bold)
                Text(student.phone, color = Purple, fontSize = 12.sp)
            }

            CircularProgressWithLabel(score = student.percentage, total = 100, color = Purple)
        }
    }
}
