//package com.example.myapplication.uis.components.Common
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//
//Row(
//verticalAlignment = Alignment.CenterVertically
//) {
//    Row(
//        modifier = Modifier,
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy((-12).dp) // negative spacing = overlap
//    ) {
//        assignment.avatars.take(3).forEach { avatar ->
//            Image(
//                painter = painterResource(id = avatar),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(28.dp)
//                    .clip(RoundedCornerShape(50))
//                    .border(2.dp, Color.White, RoundedCornerShape(50)) // optional cleaner overlap
//            )
//        }
//    }
//
//    Spacer(Modifier.width(8.dp)) // small space before "+More"
//
//    Text(
//        text = "+${assignment.moreCount} More",
//        style = MaterialTheme.typography.bodySmall
//    )
//}