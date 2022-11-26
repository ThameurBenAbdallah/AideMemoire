package com.example.aidemmoire.uiTask.uiComponents

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.aidemmoire.R



@Composable
fun AddTaskFloatingActionButton(
    openDialog:() -> Unit,

) {
    FloatingActionButton(
        onClick = {
            openDialog()
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id =  R.string.add_task)
        )
    }
}
