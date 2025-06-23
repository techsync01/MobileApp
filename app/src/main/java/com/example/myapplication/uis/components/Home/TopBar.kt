package com.example.myapplication.uis.components.Home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape

//@Composable
//fun TopBar() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Column {
//            Text("Lavanya Pathak", fontSize = 22.sp, fontWeight = FontWeight.Bold)
//            Text("English", color = Color.Gray, fontSize = 16.sp)
//        }
//        Icon(
//            imageVector = Icons.Default.Videocam,
//            contentDescription = "Video",
//            tint = Color(0xFF7C4DFF),
//            modifier = Modifier
//                .background(color = Color(0xFFEFE6FF), shape = RoundedCornerShape(12.dp))
//                .padding(10.dp)
//        )
//    }
//}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Lavanya Pathak", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.Black)
            Text("English", fontSize = 16.sp, color = Color.Gray)
        }

        Icon(
            imageVector = Icons.Default.Videocam,
            contentDescription = null,
            tint = Color(0xFF7C4DFF),
            modifier = Modifier
                .background(Color(0xFFEFE6FF), RoundedCornerShape(12.dp))
                .padding(10.dp)
        )
    }
}

