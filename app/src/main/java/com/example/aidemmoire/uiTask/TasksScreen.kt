package com.example.aidemmoire.uiTask

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aidemmoire.uiTask.screens.AddTaskAlertDialog
import com.example.aidemmoire.uiTask.screens.AddTaskFloatingActionButton
import com.example.aidemmoire.uiTask.screens.TasksContent
import com.example.aidemmoire.uiTask.screens.TasksTopBar

@Composable
@ExperimentalMaterialApi
fun TasksScreen(
    navigateToUpdateTaskScreen: (taskId: Int) -> Unit,
    viewModel: TaskViewModel = hiltViewModel()
) {

    val tasks by viewModel.tasks.collectAsState(initial = emptyList())




    Scaffold(
        topBar = {
            TasksTopBar()
        },
        content = { padding ->
            TasksContent(
                padding = padding,
                tasks = tasks,
                deleteTask = { task ->
                    viewModel.deleteTask(task)
                },
                navigateToUpdateTaskScreen = navigateToUpdateTaskScreen,
                setTaskCompleted = { task -> viewModel.setTaskCompleted(task.isCompleted) },
                unSetTaskCompleted = { task -> viewModel.unSetTaskCompleted(task.isCompleted) },

            )
            AddTaskAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addTask = { task ->
                    viewModel.addTask(task)
                }
            )
        },
        floatingActionButton = {
            AddTaskFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}




