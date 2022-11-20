package com.example.aidemmoire.uiTask.screens

import android.provider.MediaStore.MediaColumns.AUTHOR



import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidemmoire.R
import com.example.aidemmoire.data.Task

@Composable
fun UpdateTaskContent(
    padding: PaddingValues,
    task: Task,
    updateTitle: (title: String) -> Unit,
    updateAuthor: (author: String) -> Unit,
    updateTask: (Task: Task) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = task.title,

            readOnly = false,
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(
                    text = task.title
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = task.description,
            onValueChange = { description ->
                updateAuthor(description)
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.task_description)
                )
            }
        )
        Button(
            onClick = {
                updateTask(task)
                navigateBack()
            }
        ) {
            Text(
                text = stringResource(R.string.update)
            )
        }
    }
}