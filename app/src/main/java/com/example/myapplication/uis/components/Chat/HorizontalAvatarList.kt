//package com.example.myapplication.uis.components.Chat
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.myapplication.uis.model.Chat.ChatUser
//
//@Composable
//fun HorizontalAvatarList(users: List<ChatUser>) {
//    LazyRow (
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
//    ) {
//        items(users) { user ->
//            Box(modifier = Modifier.padding(end = 12.dp)) {
//                Image(
//                    painter = painterResource(id = user.avatar),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(50.dp)
//                        .clip(CircleShape)
//                )
//                if (user.isOnline) {
//                    Box(
//                        modifier = Modifier
//                            .size(12.dp)
//                            .background(Color.Green, CircleShape)
//                            .align(Alignment.BottomEnd)
//                    )
//                }
//            }
//        }
//    }
//}