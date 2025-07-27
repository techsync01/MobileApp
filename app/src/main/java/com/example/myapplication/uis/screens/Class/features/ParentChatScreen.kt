package com.example.myapplication.uis.screens.Class.features


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.uis.components.Home.Students.Chat.ChatAppBar
import com.example.myapplication.uis.components.Home.Students.Chat.ChatInputBar
import com.example.myapplication.uis.components.Home.Students.Chat.ChatMessageList
import com.example.myapplication.uis.model.Home.Class.ChatMessage
import com.example.myapplication.uis.model.Home.Class.ChatRepository
import com.example.myapplication.uis.model.Home.Class.dummyStudents
import java.time.LocalDateTime

@Composable
fun ParentChatScreen(
    studentId: Int,
    onBack: () -> Unit
) {
    val initial = remember(studentId) { ChatRepository.getConversation(studentId) }
    val messages = remember { mutableStateListOf<ChatMessage>().apply { addAll(initial) } }
    val student = dummyStudents.find { it.id == studentId } ?: dummyStudents[0]

    Scaffold(
        topBar = { ChatAppBar(title = student.name, onBack = onBack) },
        bottomBar = {
            ChatInputBar { text ->
                messages.add(
                    ChatMessage(
                        id = messages.size + 1,
                        senderId = "me",
                        text = text,
                        timestamp = LocalDateTime.now(),
                        isMine = true
                    )
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            ChatMessageList(messages = messages)
        }
    }
}



