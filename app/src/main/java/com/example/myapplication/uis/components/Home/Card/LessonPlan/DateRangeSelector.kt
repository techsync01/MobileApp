package com.example.myapplication.uis.components.Home.Card.LessonPlan
//
import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DateChipButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFF8A65FF), // Purple color similar to screenshot
        modifier = modifier
            .height(40.dp)
            .wrapContentWidth()
            .clickable(onClick = onClick),
        shadowElevation = 1.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 14.dp)
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.CalendarToday,
                contentDescription = "Select date",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun DateRangeSelector(
    modifier: Modifier = Modifier,
    onSearch: (from: Date, to: Date) -> Unit
) {
    val context = LocalContext.current
    val dateFormat = remember { SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) }
    var fromDate by remember { mutableStateOf(Date()) }
    var toDate by remember { mutableStateOf(Date()) }
    var showFromPicker by remember { mutableStateOf(false) }
    var showToPicker by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DateChipButton(
            text = dateFormat.format(fromDate),
            onClick = { showFromPicker = true }
        )

        Text(
            text = "–",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.titleLarge
        )

        DateChipButton(
            text = dateFormat.format(toDate),
            onClick = { showToPicker = true }
        )

        Spacer(modifier = Modifier.weight(30f))

        IconButton(
            onClick = { onSearch(fromDate, toDate) },
//            modifier = Modifier
//                .size(40.dp)
//                .background(
//                    color = Color(0xFF8A65FF),
//                    shape = MaterialTheme.shapes.medium
//                )
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Black
            )
        }
    }

    if (showFromPicker) {
        val calendar = Calendar.getInstance()
        calendar.time = fromDate
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                fromDate = calendar.time
                showFromPicker = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    if (showToPicker) {
        val calendar = Calendar.getInstance()
        calendar.time = toDate
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                toDate = calendar.time
                showToPicker = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}
