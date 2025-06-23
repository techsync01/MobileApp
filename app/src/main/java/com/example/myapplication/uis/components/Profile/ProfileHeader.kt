package com.example.myapplication.uis.components.Profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun ProfileHeader(onEditClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F6FE))
            .padding(top = 48.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Account", style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(R.drawable.avtar1),
            contentDescription = "Profile",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Lavanya Pathak", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
        Text("+91-9875352416", color = Color.Gray)

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
//            onClick = { /* TODO */ },
            onClick = onEditClick,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF7C4DFF))
        ) {
            Text("Edit")
            Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(18.dp))
        }
    }
}
