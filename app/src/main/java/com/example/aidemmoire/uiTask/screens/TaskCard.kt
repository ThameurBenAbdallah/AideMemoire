package com.example.aidemmoire.uiTask.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidemmoire.data.Task

@OptIn(ExperimentalMaterialApi::class)
@Composable
@ExperimentalComposeApi
fun TaskCard(task: Task,
             deleteTask :()-> Unit,
             navigateToUpdateTaskScreen: (taskId:Int) -> Unit
){
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateTaskScreen(task.id)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TaskTitle(
                    taskTitle = task.title
                )
                TaskDescription(
                    taskDescription = task.description
                )
                TaskDate(
                    taskDate = task.dueDate
                )
                TaskDate(
                    taskDate = task.dueTime
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteTask= deleteTask
            )
        }
    }
}