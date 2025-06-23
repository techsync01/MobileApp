//package com.example.myapplication.uis.components.Achievement
//
//import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.example.myapplication.uis.model.Achievement.AchievementItem
//
//@Composable
//fun LeaderBoardCard(item: AchievementItem) {
//    Card (
//        modifier = Modifier
//            .padding(8.dp)
//            .height(120.dp)
//            .weight(1f),
//        shape = RoundedCornerShape(12.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column (modifier = Modifier.padding(16.dp)) {
//            Text(item.value, style = MaterialTheme.typography.headlineMedium, color = Color(0xFF7C4DFF))
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(item.label)
//        }
//    }
//}
//
//@Composable
//fun LeaderBoardCardList(stats: List<AchievementItem>) {
//    Column {
//        Row  {
//            LeaderBoardCard(stats[0])
//            LeaderBoardCard(stats[1])
//        }
//        Row {
//            LeaderBoardCard(stats[2])
//            LeaderBoardCard(stats[3])
//        }
//    }
//}


package com.example.myapplication.uis.components.Achievement

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.model.Achievement.AchievementItem

@Composable
fun LeaderBoardCard(item: AchievementItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(170.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                item.value,
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF7C4DFF)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(item.label)
        }
    }
}

@Composable
fun LeaderBoardCardList(stats: List<AchievementItem>) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            LeaderBoardCard(stats[0], modifier = Modifier.weight(1f))
            LeaderBoardCard(stats[1], modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            LeaderBoardCard(stats[2], modifier = Modifier.weight(1f))
            LeaderBoardCard(stats[3], modifier = Modifier.weight(1f))
        }
    }
}
