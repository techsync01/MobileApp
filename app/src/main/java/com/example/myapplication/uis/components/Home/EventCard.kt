package com.example.myapplication.uis.components.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.uis.model.Home.EventItem

@Composable
fun EventCard(item: EventItem) {
    Card (
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(end = 12.dp)
            .width(250.dp)
            .height(140.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row (modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = Color(0xFF7C4DFF),
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column  {
                Text(item.title, fontWeight = FontWeight.Bold)
                Text(item.description, fontSize = 13.sp, color = Color.Gray)
                Text(item.date, fontSize = 12.sp, color = Color(0xFF7C4DFF), modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}
