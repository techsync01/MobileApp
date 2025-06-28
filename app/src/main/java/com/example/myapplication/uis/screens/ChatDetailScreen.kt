package com.example.myapplication.uis.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import com.example.myapplication.uis.model.Chat.ChatMessage
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Chat.ChatMessageBubble

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun ChatDetailScreen(chatId: String, onBackClick: () -> Unit) {
    val dummyMessages = listOf(
        ChatMessage("user", "Hey good morning mam! How are u??", "12:20"),
        ChatMessage("user", "Hey good morning mam! How are u??", "12:20"),

        ChatMessage("me", "Good Morning Shubham! I am good...", "12:20"),
        ChatMessage("user", "Sorry Mam!!!!!!!!!!", "12:20"),
        ChatMessage("me", "Ok! Kindly join class tomorrow...", "12:20")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shubham Mishra") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Call, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF7C4DFF))
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(dummyMessages) { message ->
                    ChatMessageBubble(message)
                }
            }

            Row(modifier = Modifier.padding(8.dp)) {
                TextField(value = "", onValueChange = { }, placeholder = { Text("Type your message") }, modifier = Modifier.weight(1f))
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Send, contentDescription = null)
                }
            }
        }
    }
}
