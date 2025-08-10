package com.example.myapplication.uis.screens.HomeCard.Exam.Inside

//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.myapplication.uis.components.Home.Students.Exam.EnterMarksButton
//import com.example.myapplication.uis.components.Home.Students.Exam.LanguageDropdown
//import com.example.myapplication.uis.components.Home.Students.Exam.ProfileSection
//import com.example.myapplication.uis.components.Home.Students.Exam.ReportCardTable
//import com.example.myapplication.uis.components.Home.Students.Exam.TopBarWithBack
//import com.example.myapplication.uis.model.Home.Class.dummyStudents
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ReportCardScreen(studentId: Int, navController: NavController) {
//    val student = dummyStudents.find { it.id == studentId } ?: dummyStudents[0]
//
//    Scaffold(
//        topBar = {
//            TopBarWithBack (
//                title = "Report Card",
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xFFF8F8FF))
//                .padding(paddingValues),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            ProfileSection(student)
//            Spacer(Modifier.height(20.dp))
//
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                shape = RoundedCornerShape(16.dp),
//                elevation = CardDefaults.cardElevation(6.dp)
//            ) {
//                Column(Modifier.padding(16.dp)) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text("Report Card", style = MaterialTheme.typography.titleMedium)
//                        LanguageDropdown()
//                    }
//                    Spacer(Modifier.height(12.dp))
//                    ReportCardTable(student)
//                }
//            }
//            Spacer(Modifier.height(20.dp))
//            EnterMarksButton {
//                navController.navigate("further_marks")
//            }
//        }
//    }
//}
//



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Students.Exam.ReportCardHeader
import com.example.myapplication.uis.components.Home.Students.Exam.ReportTable
import com.example.myapplication.uis.components.Home.Students.Exam.StudentInfoSection

data class ReportCardEntry(
    val title: String,
    val maxMarks: String,
    val obtained: String,
    val grade: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportCardScreen(studentId: Int, navController: NavController) {
    Scaffold(
        topBar = { ReportCardHeader(navController) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StudentInfoSection(name = "Harshvardhan", rollNumber = "1")
            Spacer(modifier = Modifier.height(16.dp))
            ReportTable(
                entries = listOf(
                    ReportCardEntry("UT-I", "50", "19", "C"),
                    ReportCardEntry("UT-II", "50", "22", "A"),
                    ReportCardEntry("Half Yearly", "100", "78", "B1"),
                    ReportCardEntry("UT-III", "50", "25", "B"),
                    ReportCardEntry("UT-IV", "-", "-", "-"),
                    ReportCardEntry("Practice Exam", "-", "-", "-"),
                    ReportCardEntry("Final Year", "-", "-", "-")
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate("make_report/$studentId") },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Enter Further Marks")
            }
        }
    }
}


//
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.myapplication.uis.model.Home.Cards.Exam.DummyPerformanceRepo
//
//@Composable
//fun ReportCardScreen(studentId: Int, navController: NavController) {
//    val performance = DummyPerformanceRepo.getPerformanceById(studentId)
//
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        Text(
//            text = "Report Card",
//            style = MaterialTheme.typography.headlineMedium,
//            modifier = Modifier.padding(bottom = 12.dp)
//        )
//
//        performance?.subjects?.let { subjects ->
//            LazyColumn {
//                items(subjects.size) { index ->
//                    val subject = subjects[index]
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 6.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(text = subject.name, modifier = Modifier.weight(1f))
//
//                        Pill(text = "100", color = Color(0xFFE0E0E0))
//                        Pill(text = subject.marks.toString(), color = Color(0xFFD1C4E9))
//                        Pill(text = subject.grade, color = Color(0xFFB39DDB))
//                    }
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//        Button(onClick = {
//            navController.navigate("make_report/$studentId")
//        }) {
//            Text("Make Report")
//        }
//    }
//}
//
//@Composable
//fun Pill(text: String, color: Color) {
//    Surface(
//        color = color,
//        shape = RoundedCornerShape(50),
//        modifier = Modifier
//            .padding(horizontal = 4.dp)
//            .widthIn(min = 60.dp)
//    ) {
//        Box(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)) {
//            Text(text = text)
//        }
//    }
//}
