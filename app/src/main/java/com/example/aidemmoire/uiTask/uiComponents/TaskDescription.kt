package com.example.aidemmoire.uiTask.uiComponents


import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import com.example.aidemmoire.R


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
        enabled = false,
        label = {Text(stringResource(R.string.task_description))},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Yellow),

    )
}