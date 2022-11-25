package com.example.aidemmoire.uiTask.screens


import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Composable
fun TaskDescription (taskDescription: String) {
   /* Text(
        text = taskDescription,
        color = Color.DarkGray,
        fontSize = 12.sp,
        textDecoration = TextDecoration.Underline
    )*/
    OutlinedTextField(
        value = taskDescription,
        onValueChange = {},
        label = {Text("Task description")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Yellow)
    )
}