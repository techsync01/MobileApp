package com.example.myapplication.uis.components.Profile.Edit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtons(
    onChangePasswordClick: () -> Unit,
    onEditClick: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
    ) {
        Button (
            onClick = onChangePasswordClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C4DFF)),
            modifier = Modifier.weight(1f)
        ) {
            Text("Change Password")
        }

        OutlinedButton (
            onClick = onEditClick,
            border = BorderStroke(1.dp, Color(0xFF7C4DFF)),
            modifier = Modifier.weight(1f)
        ) {
            Text("Edit Profile", color = Color(0xFF7C4DFF))
        }
    }
}
