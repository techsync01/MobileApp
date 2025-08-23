//package com.example.myapplication.uis.components.Home.Card.Dues
//
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.myapplication.R
//import com.example.myapplication.uis.model.Home.Class.StudentDetails
//
//@Composable
//fun StudentCard(student: StudentDetails, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .clickable { onClick() },
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
//
//            Box {
//                Image(
//                    painter = painterResource(id = student.image),
//                    contentDescription = student.name,
//                    modifier = Modifier
//                        .size(48.dp)
//                        .background(Color.LightGray, CircleShape)
//                )
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .background(Color(0xFF7C4DFF), RoundedCornerShape(4.dp))
//                        .padding(horizontal = 6.dp, vertical = 2.dp)
//                ) {
//                    Text(text = student.roleNumber.toString(), fontSize = 12.sp, color = Color.White)
//                }
//            }
//
//            Spacer(modifier = Modifier.width(12.dp))
//
//            Column(modifier = Modifier.weight(1f)) {
//                Text(student.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.avtar1),
//                        contentDescription = null,
//                        tint = Color(0xFF7C4DFF),
//                        modifier = Modifier.size(14.dp).padding(end = 4.dp)
//                    )
//                    Text(student.phone, fontSize = 12.sp, color = Color(0xFF7C4DFF))
//                }
//            }
//
//            if (student.isSubmitted) {
//                Text("Cleared", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
//            } else {
//                Text("Due", color = Color.Red, fontWeight = FontWeight.Bold)
//            }
//        }
//    }
//}



package com.example.myapplication.uis.components.Home.Card.Dues

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.uis.model.Home.Class.StudentDetails

@Composable
fun StudentCard(student: StudentDetails, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 4.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 🔹 Avatar with Roll Number Badge
            Box(modifier = Modifier.size(55.dp)) {
                Image(
                    painter = painterResource(id = student.image),
                    contentDescription = student.name,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .background(Color(0xFF7C4DFF), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = student.roleNumber.toString().padStart(2, '0'),
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // 🔹 Name & Phone
            Column(modifier = Modifier.weight(1f)) {
                Text(student.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Phone",
                        tint = Color(0xFF6200EE), // purple tint (same as your theme)
                        modifier = Modifier.size(20.dp)
                    )
                    Text(student.phone, fontSize = 13.sp, color = Color(0xFF7C4DFF))
                }
            }

            // 🔹 Status Badge
            if (student.isSubmitted) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFFE8F5E9), RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Cleared",
                        tint = Color(0xFF2E7D32), // Green
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Cleared", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFFFFEBEE), RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Due",
                        tint = Color.Red,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Due", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    }
}
