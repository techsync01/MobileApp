package com.example.myapplication.uis.components.Home.Card.Dues


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DuesCard(
    className: String,
    section: String,
    percentage: Int,
    bgColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp),

    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .width(80.dp)
                    .background(bgColor.copy(alpha = 0.2f))
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = className, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = bgColor)
                Text(text = section, fontSize = 10.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text("Cleared", fontSize = 14.sp, color = Color.Gray)
                Text("$percentage%", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
