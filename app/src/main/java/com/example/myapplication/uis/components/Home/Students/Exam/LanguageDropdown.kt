package com.example.myapplication.uis.components.Home.Students.Exam



import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportCardDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("English") }
    val languages = listOf("English", "Hindi", "French")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedLanguage,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.menuAnchor().size(width = 110.dp, height = 40.dp),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = MaterialTheme.colorScheme.surface
//            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    text = { Text(language) },
                    onClick = {
                        selectedLanguage = language
                        expanded = false
                    }
                )
            }
        }
    }
}


//
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LanguageDropdown() {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedLanguage by remember { mutableStateOf("English") }
//    val languages = listOf("English", "Hindi", "French")
//
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = { expanded = !expanded }
//    ) {
//        TextField(
//            value = selectedLanguage,
//            onValueChange = {},
//            readOnly = true,
//            shape = RoundedCornerShape(12.dp),
//            modifier = Modifier.menuAnchor().width(120.dp),
//            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) }
//        )
//        ExposedDropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            languages.forEach {
//                DropdownMenuItem(
//                    text = { Text(it) },
//                    onClick = {
//                        selectedLanguage = it
//                        expanded = false
//                    }
//                )
//            }
//        }
//    }
//}
