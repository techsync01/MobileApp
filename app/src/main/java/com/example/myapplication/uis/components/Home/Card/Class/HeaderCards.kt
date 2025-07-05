package com.example.myapplication.uis.components.Home.Card.Class

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Composable
fun HeaderCards() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Assigned Teachers
        Card(
            modifier = Modifier
                .weight(1f)
                .height(140.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.avtar1), // replace with your icon
                    contentDescription = "Teachers",
                    tint = Color(0xFF0288D1),
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("7", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("Assigned\nTeachers", fontSize = 14.sp, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Image(
                        painter = painterResource(R.drawable.avtar1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(R.drawable.avtar1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .offset(x = (-8).dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.avtar1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .offset(x = (-16).dp)
                    )
                    Text("+4", fontSize = 12.sp, modifier = Modifier.offset(x = (-12).dp))
                }
            }
        }

        // Assignments & Fee cards in Column
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {

            // Assignment Submitted
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEDE7F6)),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.avtar1), // replace with your icon
                        contentDescription = "Assignment",
                        tint = Color(0xFF7C4DFF),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("33", fontWeight = FontWeight.Bold)
                        Text("Assignment Submitted", fontSize = 12.sp)
                    }
                }
            }

            // Fee Paid
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.avtar1), // replace with your icon
                        contentDescription = "Fee",
                        tint = Color(0xFFFF7043),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("74%", fontWeight = FontWeight.Bold)
                        Text("Fee Paid", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}
