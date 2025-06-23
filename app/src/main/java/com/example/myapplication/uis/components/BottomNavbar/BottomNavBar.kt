package com.example.myapplication.uis.components.BottomNavbar


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.EmojiEvents,
        Icons.Default.ChatBubble,
        Icons.Default.Description,
        Icons.Default.Person
    )

    val labels = listOf("Home", "Achievements", "Chat", "Syllabus", "Profile")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icons.forEachIndexed { index, icon ->
                if (index == 2) {
                    Spacer(modifier = Modifier.width(1.dp))
                } else {
                    NavigationIcon(
                        icon = icon,
                        label = labels[index],
                        selected = index == selectedIndex,
                        onClick = { onItemSelected(index) }
                    )
                }
            }
        }

//        Box(
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .offset(y = (-20).dp)
//                .size(60.dp)
//                .background(Color(0xFF7C4DFF), shape = androidx.compose.foundation.shape.RoundedCornerShape(30.dp)),
//            contentAlignment = Alignment.Center
//        ) {
//            Icon(
//                imageVector = Icons.Default.ChatBubble,
//                contentDescription = "Chat",
//                tint = Color.White,
//                modifier = Modifier.size(28.dp)
//            )
//        }
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-20).dp)
                .size(60.dp)
                .clickable { onItemSelected(2) } // ✅ Make it clickable
                .background(Color(0xFF7C4DFF), shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ChatBubble,
                contentDescription = "Chat",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }

    }
}

@Composable
fun NavigationIcon(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(top = 6.dp, bottom = 4.dp)
            .width(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) Color(0xFF7C4DFF) else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        if (selected) {
            Box(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .height(4.dp)
                    .width(24.dp)
                    .background(
                        color = Color(0xFF7C4DFF),
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(2.dp)
                    )
            )
        }
    }
}
