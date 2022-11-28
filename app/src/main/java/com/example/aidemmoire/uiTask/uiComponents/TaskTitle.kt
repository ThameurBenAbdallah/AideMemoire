package com.example.aidemmoire.uiTask.uiComponents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Composable
fun TaskTitle(taskTitle: String) {
/*    outLinedTextField(
    text = taskTitle,
    color = Color.DarkGray,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
    fontSize = 12.sp,
    textDecoration = TextDecoration.Underline
)*/
    Text(
        text = taskTitle.toString(),
        color = Color.DarkGray,
        fontSize = 16.sp,
        textDecoration = TextDecoration.Underline
    )
  /*  OutlinedTextField(
        value = taskTitle,
        onValueChange = {},
        label = {Text("Title")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Yellow)
    )*/
}