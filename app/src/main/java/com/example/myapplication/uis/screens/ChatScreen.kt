
package com.example.myapplication.uis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.uis.components.Chat.ChatListItem
import com.example.myapplication.uis.model.Chat.ChatUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(onChatClick: (String) -> Unit) {
    val dummyChats = listOf(
        ChatUser("1", "Shubham Mishra", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("2", "Anurag Dixit", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", false),
        ChatUser("3", "Kalpana Sharma", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("1", "Shubham Mishra", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("2", "Anurag Dixit", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", false),
        ChatUser("3", "Kalpana Sharma", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("1", "Shubham Mishra", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("2", "Anurag Dixit", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", false),
        ChatUser("3", "Kalpana Sharma", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("1", "Shubham Mishra", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
        ChatUser("2", "Anurag Dixit", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", false),
        ChatUser("3", "Kalpana Sharma", R.drawable.avtar1, "Hey good morning mam! I just want...", "12:20", true),
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF7C4DFF)) // Full purple background, including status bar area
    ) {

        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, contentDescription = null, tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF7C4DFF))
        )

        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(dummyChats) { user ->
                Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Box {
                        Surface(
                            shape = CircleShape,
                            border = null,
                            modifier = Modifier.size(50.dp)
                        ) {
                            Image(
                                painter = painterResource(id = user.avatar),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                        if (user.isOnline) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .background(Color.Green, CircleShape)
                                    .align(Alignment.BottomEnd)
                                    .offset(2.dp, 2.dp)
                            )
                        }
                    }
                }
            }
        }

        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            LazyColumn {
                items(dummyChats) { chat ->
                    ChatListItem(chatUser = chat, onClick = { onChatClick(chat.id) })
                }
            }
        }
    }
}
