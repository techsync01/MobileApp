package com.example.myapplication.uis.components.Home.Card.Assignments

import androidx.compose.foundation.Image


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.model.Home.Class.StudentDetails

@Composable
fun StudentSubmissionCard(student: StudentDetails) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
//        colors = CardDefaults.cardColors()
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar with Roll number overlapping
            Box(modifier = Modifier.size(60.dp)) {
                Image(
                    painter = painterResource(id = student.image),
                    contentDescription = student.name,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = (-12).dp) // overlap left center
                        .clip(RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = student.roleNumber.toString().padStart(2, '0'),
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(student.name, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Phone",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(student.phone, color = MaterialTheme.colorScheme.primary, fontSize = 13.sp)
                }
            }

            // Submission Status
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (student.isSubmitted) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Submitted",
                        tint = Color(0xFF00C853), // green
                        modifier = Modifier.size(22.dp)
                    )
                    Text("Submitted", color = Color(0xFF00C853), fontSize = 12.sp)
                } else {
                    Icon(
                        imageVector = Icons.Default.RadioButtonUnchecked,
                        contentDescription = "Not Submitted",
                        tint = Color.Gray,
                        modifier = Modifier.size(22.dp)
                    )
                    Text("Submitted", color = Color.Gray, fontSize = 12.sp)
                }
            }
        }
    }
}

