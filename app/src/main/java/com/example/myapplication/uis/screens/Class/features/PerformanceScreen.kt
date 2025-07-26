


package com.example.myapplication.uis.screens.student.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.CloudDownload
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.uis.components.Home.Students.Performance.*
import com.example.myapplication.uis.model.Home.Class.DummyPerformanceRepo
import com.example.myapplication.uis.model.Home.Class.ExamType
import com.example.myapplication.uis.model.Home.Class.StudentPerformanceData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerformanceScreen(
    navController: NavController,
    studentId: Int
) {
    // 1) Pull the data for this student
    val performance: StudentPerformanceData = remember(studentId) {
        DummyPerformanceRepo.getPerformance(studentId)
    }

    // 2) One state to control both sections’ dropdown
    var selectedExam by remember { mutableStateOf(ExamType.HALF_YEARLY) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Performance") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO export*/ }) {
                        Icon(Icons.Outlined.CloudDownload, contentDescription = "Download")
                    }
                }
            )
        },
        containerColor = Color(0xFFF6F7FC)
    ) { padding ->TextFieldDefaults
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            // ---------- KPI Row ----------
            item {
                val overall = performance.overall[selectedExam]?.resultPercentage ?: 0
                val assignments = performance.assignments[selectedExam] ?: 0 to 0
                val attendance = performance.attendanceOverall[selectedExam] ?: 0

                KPIRow(
                    overallPercent = overall,
                    assignments = assignments,
                    attendancePercent = attendance
                )
            }

            // ---------- Position ----------
            item {
                Spacer(Modifier.height(16.dp))
                val pos = performance.position[selectedExam]
                PositionBanner(
                    rank = pos?.position ?: 0,
                    total = pos?.totalStudents ?: 0,
                    progress = pos?.score ?: 0
                )
            }

            // ---------- Report Card ----------
            item {
                Spacer(Modifier.height(16.dp))
                ReportCardSection(
                    selectedExam = selectedExam,
                    onExamChange = { selectedExam = it },
                    results = performance.reportCards[selectedExam].orEmpty()
                )
            }

            // ---------- Attendance ----------
            item {
                Spacer(Modifier.height(16.dp))
                AttendanceSection(
                    selectedExam = selectedExam,
                    onExamChange = { selectedExam = it },
                    subjects = performance.attendanceBySubject[selectedExam].orEmpty()
                )
            }

            item { Spacer(Modifier.height(32.dp)) }
        }
    }
}
