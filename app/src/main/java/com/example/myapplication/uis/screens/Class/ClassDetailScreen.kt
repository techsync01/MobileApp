import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.uis.components.Home.Card.Class.DateStrip
import com.example.myapplication.uis.components.Home.Card.Class.HeaderCards
import com.example.myapplication.uis.components.Home.Card.Class.OverallPerformanceChart
import com.example.myapplication.uis.components.Home.Card.Class.StudentSectionCard
import com.example.myapplication.uis.components.Home.Card.Class.TimeTableRow
import com.example.myapplication.uis.model.Home.Class.Student
import com.example.myapplication.uis.model.Home.Class.TimeTableEntry
import java.time.LocalDate

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun ClassDetailScreen(title: String, nav: NavController) {
    val today = remember { LocalDate.now() }
    val dates = (0..6).map { today.minusDays(6 - it.toLong()) }
    // Dummy timetable entries
    val sampleEntries = listOf(
        TimeTableEntry("08:00-08:45 AM", "Maths", "Trigonometry", R.drawable.avtar1),
        TimeTableEntry("08:45-09:30 AM", "English", "Present Indef. Tense", R.drawable.avtar1),
        TimeTableEntry("09:30-10:00 AM", "Social Science", "Economical Changes", R.drawable.avtar1),
        TimeTableEntry("10:00-10:30 AM", "Computer", "Abacus", R.drawable.avtar1),
        TimeTableEntry("10:30-11:00 AM", "Drawing", "Unit II", R.drawable.avtar1),
        TimeTableEntry("", "", "", 0, isBreak = true, breakLabel = "11:00–11:45 AM  Lunch Break"),
        TimeTableEntry("11:30–12:15 PM", "Hindi", "गद्य गद्यिमा", R.drawable.avtar1),
        TimeTableEntry("12:15–1:00 PM", "Yoga", "NA", R.drawable.avtar1)
    )

    val students = List(10) { Student("Student ${it + 1}", R.drawable.avtar1) }

    Scaffold (topBar = {
        TopAppBar(
            title = { Text(title) },
            navigationIcon = {
                IconButton(onClick = { nav.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

    }) { padding ->
        Column(Modifier.padding(padding)) {
            HeaderCards()
            Spacer(Modifier.height(12.dp))
//            StudentSectionCard(students.size, onClick = { nav.navigate(Screen.StudentDetail.route) })
            StudentSectionCard(students.size, onClick = {
                nav.navigate("student_screen/$title")
            })

            Spacer(Modifier.height(12.dp))
            OverallPerformanceChart()
            Spacer(Modifier.height(12.dp))
            Text("Time Table", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(start = 12.dp))
            DateStrip (dates = dates, selected = today, onDateSelected = { /* update UI if needed */ })
            Spacer(Modifier.height(8.dp))
            sampleEntries.forEach {
                TimeTableRow(entry = it)
            }
        }
    }
}
