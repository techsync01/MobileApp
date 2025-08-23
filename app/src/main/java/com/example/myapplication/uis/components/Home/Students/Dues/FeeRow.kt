//package com.example.myapplication.uis.components.Home.Students.Dues
//
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.ArrowOutward
//import androidx.compose.material3.Divider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import com.example.myapplication.uis.model.Home.Class.FeePayment
//import java.time.format.DateTimeFormatter
//
//@Composable
//fun FeeRow(
//    fee: FeePayment,
//    amountColor: Color = Color(0xFF8150FF),
//    dotColor: Color = Color(0xFFFF5E99),
//) {
//    Column(Modifier.fillMaxWidth()) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(10.dp)
//                    .background(dotColor, shape = MaterialTheme.shapes.small)
//            )
//            Spacer(Modifier.width(8.dp))
//
//            val dateStr = fee.date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
//            val timeStr = fee.time.format(DateTimeFormatter.ofPattern("HH:mm"))
//
//            Text(
//                text = "$dateStr  $timeStr",
//                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
//            )
//
//            Spacer(Modifier.weight(1f))
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Icon(
//                    imageVector = Icons.Outlined.ArrowOutward,
//                    contentDescription = null,
//                    tint = amountColor,
//                    modifier = Modifier.size(16.dp)
//                )
//                Spacer(Modifier.width(4.dp))
//                Text(
//                    text = "₹${fee.amount} paid",
//                    style = MaterialTheme.typography.titleSmall.copy(color = amountColor)
//                )
//            }
//        }
//
//        fee.remark?.let {
//            Spacer(Modifier.height(6.dp))
//            Text(it, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
//        }
//
//        Spacer(Modifier.height(12.dp))
//        Divider(color = Color(0xFFEDEDED))
//    }
//}


package com.example.myapplication.uis.components.Home.Students.Dues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowOutward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Home.Class.FeePayment
import java.time.format.DateTimeFormatter

@Composable
fun FeeRow(
    fee: FeePayment,
    amountColor: Color = Color(0xFF8150FF),
    dotColor: Color = Color(0xFFFF5E99),
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp), // spacing between cards
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // subtle shadow
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // inner padding for content
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(dotColor, shape = MaterialTheme.shapes.small)
                )
                Spacer(Modifier.width(8.dp))

                val dateStr = fee.date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
                val timeStr = fee.time.format(DateTimeFormatter.ofPattern("HH:mm"))

                Text(
                    text = "$dateStr  $timeStr",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(Modifier.weight(1f))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowOutward,
                        contentDescription = null,
                        tint = amountColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "₹${fee.amount} paid",
                        style = MaterialTheme.typography.titleSmall.copy(color = amountColor)
                    )
                }
            }

            fee.remark?.let {
                Spacer(Modifier.height(8.dp))
                Text(
                    it,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

