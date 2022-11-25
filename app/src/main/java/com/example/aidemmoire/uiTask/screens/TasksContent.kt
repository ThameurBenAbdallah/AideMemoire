package com.example.aidemmoire.uiTask.screens
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import com.example.aidemmoire.data.Task
import com.example.aidemmoire.data.Tasks


@OptIn(ExperimentalComposeApi::class)
@Composable
@ExperimentalMaterialApi
fun TasksContent(padding: PaddingValues,
                tasks:Tasks,
                navigateToUpdateTaskScreen : (taskId: Int) -> Unit,
                 deleteTask:(task:Task) -> Unit,
                 setTaskCompleted:(task:Task) -> Unit,
                 unSetTaskCompleted : (task:Task) -> Unit
)


{
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = tasks
        ) { task ->
            TaskCard(
                task = task,
                deleteTask = {
                    deleteTask(task)
                },
                navigateToUpdateTaskScreen = navigateToUpdateTaskScreen,
                setTaskCompleted = {setTaskCompleted(task)         },
                unSetTaskCompleted = { unSetTaskCompleted(task) },
                isChecked = task.isCompleted
            )
        }
    }
}