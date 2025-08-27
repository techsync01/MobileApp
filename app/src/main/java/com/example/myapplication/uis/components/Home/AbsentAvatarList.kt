package com.example.myapplication.uis.components.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AbsentAvatarList(avatarList: List<Int>) {


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Overlapping avatars
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy((-12).dp) // negative spacing for overlap
        ) {
            avatarList.take(3).forEach { resId ->
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(50))
                        .border(2.dp, Color.White, RoundedCornerShape(50))
                )
            }
        }

        Spacer(Modifier.width(8.dp)) // spacing before "+More" text

        // "+More" text if there are more avatars than shown

            Text(
                text = "+9 More",
                style = MaterialTheme.typography.bodySmall
            )

    }


}
