package com.example.myapplication.uis.components.Home.Students.Exam



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.myapplication.R


@Composable
fun StudentInfoSection(name: String, rollNumber: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.avtar1),
            contentDescription = "Profile",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = "Roll Number: $rollNumber", color = Color.Gray, fontSize = 14.sp)
    }
}
