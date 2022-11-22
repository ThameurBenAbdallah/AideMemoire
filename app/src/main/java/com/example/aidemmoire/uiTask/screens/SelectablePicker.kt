package com.example.aidemmoire.uiTask.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SelectablePicker(
    modifier: Modifier = Modifier,
    textValue: String,
    Icon: @Composable (() -> Unit),
    onClick: () -> Unit,
) {
    TextField(
        value = textValue,
        leadingIcon = Icon,
        onValueChange = { },
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        enabled = false
    )
}
