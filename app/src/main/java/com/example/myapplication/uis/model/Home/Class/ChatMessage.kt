package com.example.myapplication.uis.model.Home.Class

import androidx.annotation.DrawableRes
import java.time.LocalDateTime
import com.example.myapplication.R


data class ChatMessage(
    val id: Int,
    val senderId: String,          // "me" / "other" (or any unique id)
    val text: String,
    val timestamp: LocalDateTime,
    val isMine: Boolean,
    @DrawableRes val avatar: Int? = null
)





object ChatRepository {

    fun getConversation(studentId: Int): List<ChatMessage> {
        // You can vary studentId to return different data
        val otherId = "student_$studentId"
        val meId = "me"

        return listOf(
            ChatMessage(1, otherId, "Hey good morning mam! How are u??", LocalDateTime.now().minusMinutes(20), false, R.drawable.avtar1),
            ChatMessage(2, meId, "Good Morning Shubham! I am good, what about you?? why u didn’t join class??", LocalDateTime.now().minusMinutes(18), true),
            ChatMessage(3, otherId, "Sorry Mam!!!!!!!!!!", LocalDateTime.now().minusMinutes(17), false, R.drawable.avtar1),
            ChatMessage(4, otherId, "Actually I m out of town due to family function at village", LocalDateTime.now().minusMinutes(17), false, R.drawable.avtar1),
            ChatMessage(5, meId, "Ok! Kindly join class tomorrow. It’s Important!!", LocalDateTime.now().minusMinutes(15), true)
        )
    }
}
