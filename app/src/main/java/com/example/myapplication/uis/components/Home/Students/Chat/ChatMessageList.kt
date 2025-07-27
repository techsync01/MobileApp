package com.example.myapplication.uis.components.Home.Students.Chat


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.myapplication.uis.model.Home.Class.ChatMessage

@Composable
fun ChatMessageList(messages: List<ChatMessage>) {
    LazyColumn {
        item { DayDivider("Today") }

        itemsIndexed(messages) { index, msg ->
            val next = messages.getOrNull(index + 1)
            val showAvatar = !msg.isMine && (next == null || next.senderId != msg.senderId)
            ChatBubble(message = msg, showAvatar = showAvatar)
        }
    }
}
