package com.example.aidemmoire.uiTask.uiComponents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

@Composable
fun TaskDate(taskDate: String) {
    Text(

        text = taskDate,
        color = Color.DarkGray,
        fontSize = 18.sp,

    )
}