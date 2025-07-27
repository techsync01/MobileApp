package com.example.myapplication.uis.screens.Class.features


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Home.Students.Dues.CalendarHeader
import com.example.myapplication.uis.components.Home.Students.Dues.CalendarMonth
import com.example.myapplication.uis.components.Home.Students.Dues.FeeRow
import com.example.myapplication.uis.model.Home.Class.FeeRepository
import java.time.LocalDate
import java.time.YearMonth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeeDetailsScreen(
    studentId: Int,
    onBack: () -> Unit
) {
    val purple = Color(0xFF8150FF)
    val pinkPaid = Color(0xFFFF5E99)

    val payments = remember(studentId) { FeeRepository.getPayments(studentId) }
    val paidDates = remember(payments) { payments.map { it.date }.toSet() }

    val today = remember { LocalDate.now() }
    var currentMonth by remember { mutableStateOf(YearMonth.from(today)) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fee Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = purple,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF6F7FC))
        ) {

            // ------- Fixed Calendar Block (non-scrollable) -------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(purple)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Column {
                    CalendarHeader(
                        currentMonth = currentMonth,
                        onPrev = { currentMonth = currentMonth.minusMonths(1) },
                        onNext = { currentMonth = currentMonth.plusMonths(1) },
                        titleColor = Color.White
                    )

                    Spacer(Modifier.height(12.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                        color = Color.White
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            CalendarMonth(
                                month = currentMonth,
                                today = today,
                                paidDates = paidDates,
                                todayColor = purple,
                                paidColor = pinkPaid
                            )
                        }
                    }
                }
            }

            // ------- Scrollable list -------
            val monthPayments = remember(currentMonth, payments) {
                payments.filter { YearMonth.from(it.date) == currentMonth }
                    .sortedBy { it.date }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                items(monthPayments) { fee ->
                    FeeRow(
                        fee = fee,
                        amountColor = purple,
                        dotColor = pinkPaid
                    )
                }
            }
        }
    }
}
