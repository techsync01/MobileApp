package com.example.myapplication.uis.screens

import EditableField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.uis.components.Profile.Edit.ActionButtons
import com.example.myapplication.uis.components.Profile.Edit.EditTopBar
import com.example.myapplication.uis.components.Profile.Edit.ProfileImageSection
import com.example.myapplication.uis.model.Edit.UserProfile

@Composable
fun ProfileEditScreen(
    user: UserProfile,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    onChangePasswordClick: () -> Unit
) {
    Scaffold (
        topBar = {
            EditTopBar(onBackClick)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            ProfileImageSection()

            Spacer(modifier = Modifier.height(16.dp))

            EditableField(icon = Icons.Default.Person, label = "Name", value = user.name)
            EditableField(icon = Icons.Default.Email, label = "Email", value = user.email)
            EditableField(icon = Icons.Default.Phone, label = "Phone", value = user.phone)
            EditableField(icon = Icons.Default.School, label = "Class", value = user.className)
            EditableField(icon = Icons.Default.MenuBook, label = "Subject", value = user.subject)

            Spacer(modifier = Modifier.height(24.dp))

            ActionButtons (
                onEditClick = onEditClick,
                onChangePasswordClick = onChangePasswordClick
            )
        }
    }
}
