package com.example.aidemmoire.uiTask.screens

import android.service.autofill.OnClickAction
import android.util.Log
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidemmoire.data.Task
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
@ExperimentalComposeApi
fun TaskCard(task: Task,
             deleteTask :()-> Unit,
             navigateToUpdateTaskScreen: (taskId:Int) -> Unit,
             setTaskCompleted : (task: Task) -> Unit,


){
    var checked: Boolean by remember { mutableStateOf(false) }
    Log.d("Thameur initial", "$checked")


    Card(
        shape = MaterialTheme.shapes.medium,
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
            Column {
                DeleteIcon(
                    deleteTask = deleteTask

                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                CheckBoxComplete(checked,
                onClick = {checked = !checked
                    Log.d("Thameur onClick", "$checked")},

                )




            }

        }
    }
    if (checked) { setTaskCompleted(task)
        Log.d("Thameur callback", "$checked")}
}
@Composable
fun CheckBoxComplete(
    checked: Boolean,
    onClick:() -> Unit,



) {
    Checkbox(
        checked= checked ,
        onCheckedChange = {onClick()} ,
        enabled = true

        )
    }




