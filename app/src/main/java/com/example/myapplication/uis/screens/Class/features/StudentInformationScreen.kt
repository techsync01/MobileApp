//package com.example.myapplication.uis.screens.Class.features
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.myapplication.R
//import com.example.myapplication.uis.model.Home.Class.StudentDetails
//import com.example.myapplication.uis.model.Home.Class.dummyStudents
//
//@Composable
//fun StudentInformationScreen(navController: NavController) {
//    val student = dummyStudents.find { it.name == "Anish Taneja" } ?: dummyStudents[0]
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF5F7FA))
//            .padding(16.dp)
//    ) {
//        // Back Button
//        IconButton(onClick = { navController.popBackStack() }) {
//            Icon(
//                painter = painterResource(id = android.R.drawable.ic_menu_revert),
//                contentDescription = "Back",
//                modifier = Modifier.size(24.dp)
//            )
//        }
//
//        // Profile Image
//        Image(
//            painter = painterResource(id = student.image),
//            contentDescription = "Profile Picture",
//            modifier = Modifier
//                .size(100.dp)
//                .clip(CircleShape)
//                .align(Alignment.CenterHorizontally)
//        )
//
//        // Name
//        Text(
//            text = student.name,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(top = 8.dp)
//        )
//
//        // Phone
//        Text(
//            text = student.phone,
//            fontSize = 16.sp,
//            color = Color.Gray,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(top = 4.dp)
//        )
//
//        // Information Fields
//        Spacer(modifier = Modifier.height(16.dp))
//        InformationField(label = "Email", value = student.email)
//        InformationField(label = "Class", value = student.className)
//        InformationField(label = "Role Number", value = student.roleNumber.toString())
//        InformationField(label = "Father's Name", value = student.fathersName)
//        InformationField(label = "Father's Contact Number", value = student.fathersContact)
//        InformationField(label = "Mother's Name", value = student.mothersName)
//        InformationField(label = "Mother's Contact Number", value = student.mothersContact)
//        InformationField(label = "Date of Birth", value = student.dateOfBirth)
//        InformationField(label = "Admission Date", value = student.admissionDate)
//        InformationField(label = "House Name", value = student.houseName)
//        InformationField(label = "Permanent Address", value = student.permanentAddress)
//    }
//}
//
//@Composable
//fun InformationField(label: String, value: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp)
//            .background(Color(0xFFE0E7FF), shape = MaterialTheme.shapes.medium)
//            .padding(12.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(
//            painter = when (label) {
//                "Email" -> painterResource(id = android.R.drawable.ic_dialog_email)
//                "Class", "Role Number" -> painterResource(id = android.R.drawable.ic_dialog_info)
//                "Father's Name", "Mother's Name" -> painterResource(id = android.R.drawable.ic_menu_myplaces)
//                "Father's Contact Number", "Mother's Contact Number" -> painterResource(id = android.R.drawable.ic_menu_call)
//                "Date of Birth", "Admission Date" -> painterResource(id = android.R.drawable.ic_menu_today)
//                "House Name" -> painterResource(id = android.R.drawable.ic_dialog_map)
//                "Permanent Address" -> painterResource(id = android.R.drawable.ic_dialog_map)
//                else -> painterResource(id = android.R.drawable.ic_dialog_info)
//            },
//            contentDescription = label,
//            modifier = Modifier.size(24.dp)
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(
//            text = value,
//            fontSize = 16.sp,
//            modifier = Modifier.weight(1f)
//        )
//    }
//}


package com.example.myapplication.uis.screens.Class.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.uis.model.Home.Class.StudentDetails
import com.example.myapplication.uis.model.Home.Class.dummyStudents

@Composable
fun StudentInformationScreen(navController: NavController, studentId: Int) {
    val student = dummyStudents.find { it.id == studentId } ?: dummyStudents[0]

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                color = Color(0xFF000000)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_revert),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Profile Image
            Image(
                painter = painterResource(id = student.image),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            // Name
            Text(
                text = student.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 12.dp)
            )

            // Phone
            Text(
                text = student.phone,
                fontSize = 16.sp,
                color = Color(0xFF757575),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp)
            )

            // Scrollable Information Fields
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { InformationField(label = "Email", value = student.email) }
                item { InformationField(label = "Class", value = student.className) }
                item { InformationField(label = "Role Number", value = student.roleNumber.toString()) }
                item { InformationField(label = "Father's Name", value = student.fathersName) }
                item { InformationField(label = "Father's Contact Number", value = student.fathersContact) }
                item { InformationField(label = "Mother's Name", value = student.mothersName) }
                item { InformationField(label = "Mother's Contact Number", value = student.mothersContact) }
                item { InformationField(label = "Date of Birth", value = student.dateOfBirth) }
                item { InformationField(label = "Admission Date", value = student.admissionDate) }
                item { InformationField(label = "House Name", value = student.houseName) }
                item { InformationField(label = "Permanent Address", value = student.permanentAddress) }
            }
        }
    }
}

@Composable
fun InformationField(label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E7FF))
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = when (label) {
                    "Email" -> painterResource(id = android.R.drawable.ic_dialog_email)
                    "Class", "Role Number" -> painterResource(id = android.R.drawable.ic_dialog_info)
                    "Father's Name", "Mother's Name" -> painterResource(id = android.R.drawable.ic_menu_myplaces)
                    "Father's Contact Number", "Mother's Contact Number" -> painterResource(id = android.R.drawable.ic_menu_call)
                    "Date of Birth", "Admission Date" -> painterResource(id = android.R.drawable.ic_menu_today)
                    "House Name" -> painterResource(id = android.R.drawable.ic_dialog_map)
                    "Permanent Address" -> painterResource(id = android.R.drawable.ic_dialog_map)
                    else -> painterResource(id = android.R.drawable.ic_dialog_info)
                },
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF1976D2)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = label,
                    fontSize = 14.sp,
                    color = Color(0xFF757575),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = value,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}