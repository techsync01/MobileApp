package com.example.myapplication.uis.components.Home.Students.Exam



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.screens.HomeCard.Exam.Inside.ReportCardEntry

@Composable
fun ReportTable(entries: List<ReportCardEntry>) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Report Card", style = MaterialTheme.typography.titleMedium)
                ReportCardDropdown()
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth().background(
                    Brush.horizontalGradient(
                        listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ).padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Max Marks", color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Text("Obtained", color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Text("Grade", color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            }
            entries.forEach { entry -> ReportRow(entry) }
        }
    }
}



//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.example.myapplication.uis.model.Home.Class.StudentDetails
//import com.example.myapplication.uis.model.Home.Class.StudentPerformance
//import com.example.myapplication.uis.model.Home.Class.defaultPerformance
//
//
//@Composable
//fun ReportCardTable(
//    student: StudentDetails,
//
//) {
//    val performance= defaultPerformance
//    val columnTitles = listOf("Max Marks", "Marks Obtained", "Grade")
//
//    Row(Modifier.fillMaxWidth()) {
//        Column(
//            verticalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier.weight(1f)
//        ) {
//            performance.marks.forEach { (exam, _, _) ->
//                Text(exam, modifier = Modifier.padding(vertical = 8.dp))
//            }
//        }
//
//        columnTitles.forEachIndexed { index, title ->
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .weight(1f)
//                    .clip(RoundedCornerShape(8.dp))
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color(0xFF6A5ACD),
//                                Color(0xFF9370DB)
//                            )
//                        )
//                    )
//                    .padding(vertical = 8.dp)
//            ) {
//                VerticalText(title)
//                Spacer(Modifier.height(8.dp))
//                performance.marks.forEachIndexed { rowIndex, (_, max, obtained) ->
//                    when (index) {
//                        0 -> Text(max, color = Color.White, modifier = Modifier.padding(4.dp))
//                        1 -> Text(obtained, color = Color.White, modifier = Modifier.padding(4.dp))
//                        2 -> Text(performance.grades[rowIndex], color = Color.White, modifier = Modifier.padding(4.dp))
//                    }
//                }
//            }
//        }
//    }
//}

