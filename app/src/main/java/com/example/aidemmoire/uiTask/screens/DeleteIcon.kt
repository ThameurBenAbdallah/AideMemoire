package com.example.aidemmoire.uiTask.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.aidemmoire.R

@Composable
fun DeleteIcon(
    deleteTask:() -> Unit

){
    IconButton(
    onClick = deleteTask
) {
    Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = stringResource(R.string.delete_task),
    )
}
}