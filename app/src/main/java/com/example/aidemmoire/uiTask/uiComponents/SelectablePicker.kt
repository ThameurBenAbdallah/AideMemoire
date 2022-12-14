package com.example.aidemmoire.uiTask.uiComponents

import androidx.compose.foundation.clickable

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SelectablePicker(

    modifier: Modifier = Modifier,
    textValue: String,
    Icon: @Composable (() -> Unit),
    onClick: () -> Unit,
    placeHolderText: String,

) {
    TextField(
        value = textValue,
        onValueChange = {},
        leadingIcon = Icon,
        modifier = modifier
            .clickable { onClick() },
        enabled = false,
        placeholder = {
            Text(
                text = placeHolderText
            )
        }

    )
}
