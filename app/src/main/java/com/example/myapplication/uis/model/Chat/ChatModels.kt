package com.example.myapplication.uis.model.Chat


//data class ChatUser(
//    val id: String,
//    val name: String,
//    val avatar: Int,
//    val lastMessage: String,
//    val time: String
//)

data class ChatUser(
    val id: String,
    val name: String,
    val avatar: Int,
    val lastMessage: String,
    val time: String,
    val isOnline: Boolean
)

data class ChatMessage(
    val sender: String, // "user" or "me"
    val text: String,
    val time: String
)


