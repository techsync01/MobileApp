//package com.example.myapplication.uis.components.Profile.Edit
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun EditableField(
//    icon: ImageVector,
//    label: String,
//    value: String,
//    onValueChange: (String) -> Unit = {}
//) {
//    Column (
//        modifier = Modifier
//            .padding(horizontal = 16.dp, vertical = 6.dp)
//            .fillMaxWidth()
//            .background(Color(0xFFE7EFFB), RoundedCornerShape(12.dp))
//            .padding(12.dp)
//    ) {
//        Row (verticalAlignment = Alignment.CenterVertically) {
//            Icon(icon, contentDescription = label, modifier = Modifier.size(20.dp))
//            Spacer(modifier = Modifier.width(8.dp))
//            Column {
//                Text(text = label, style = MaterialTheme.typography.labelSmall)
//                TextField(
//                    value = value,
//                    onValueChange = onValueChange,
//                    singleLine = true,
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent
//                    )
//                )
//            }
//        }
//    }
//}


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun EditableField(
    icon: ImageVector,
    label: String,
    value: String,
    onValueChange: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .fillMaxWidth()
            .background(Color(0xFFE7EFFB), RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = label, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = label, style = MaterialTheme.typography.labelSmall)
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}
