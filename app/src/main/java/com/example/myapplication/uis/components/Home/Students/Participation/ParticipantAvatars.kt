package com.example.myapplication.uis.components.Home.Students.Participation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun ParticipantAvatars(avatars: List<Int>) {
    Row {
        avatars.take(3).forEachIndexed { index, resId ->
            val painter: Painter = painterResource(resId)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .offset(x = (-8 * index).dp)
                    .zIndex((3 - index).toFloat()),
                contentScale = ContentScale.Crop
            )
        }
    }
}
