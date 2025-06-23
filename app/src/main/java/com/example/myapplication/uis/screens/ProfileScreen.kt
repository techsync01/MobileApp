package com.example.myapplication.uis.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Profile.*

@Composable
fun ProfileScreen(onEditClick: () -> Unit) {
    Column {
        ProfileHeader(onEditClick = onEditClick)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {
            item { ProfileItem("Settings", Icons.Default.Settings) }
            item { ProfileItem("Privacy Settings", Icons.Default.Lock) }
            item { ProfileItem("Salary", Icons.Default.AccountBalanceWallet) }
            item { ProfileItem("Change Salary Account", Icons.Default.AccountBalance) }
            item { ProfileItem("Request For Leave", Icons.Default.NoteAlt) }
            item { ProfileItem("My Attendance", Icons.Default.Badge) }
            item { ProfileItem("School Terms", Icons.Default.Description) }
            item { ProfileItem("Serve Notice Period", Icons.Default.Article) }

            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { ProfileActions() }
        }
    }
}
