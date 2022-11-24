package com.example.aidemmoire.uiTask.screens

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.aidemmoire.R


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
    OutlinedTextField(
        value = taskTitle,
        onValueChange = {},
        label = { Text(stringResource(R.string.title))
        }
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