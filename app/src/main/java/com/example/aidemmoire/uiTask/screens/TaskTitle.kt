package com.example.aidemmoire.uiTask.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Composable
fun TaskTitle(taskTitle: String) {
    Text(
    text = taskTitle,
    color = Color.DarkGray,
    fontSize = 12.sp,
    textDecoration = TextDecoration.Underline
)
}