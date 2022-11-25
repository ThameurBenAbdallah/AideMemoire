package com.example.aidemmoire.uiTask

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aidemmoire.R
import com.example.aidemmoire.uiTask.screens.UpdateTaskContent
import com.example.aidemmoire.uiTask.screens.UpdateTaskTopBar


@Composable
fun UpdateTasksScreen(
    viewModel: TaskViewModel = hiltViewModel(),
    taskId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getTask(taskId)
    }
    Scaffold(
        topBar = {
            UpdateTaskTopBar(
                navigateBack = navigateBack,
                R.string.update_task
            )
        },
        content = { padding ->
            UpdateTaskContent(
                padding = padding,
                task = viewModel.task,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateDescription = { author ->
                    viewModel.updateDescription(author)
                },
                updateTask = { task ->
                    viewModel.updateTask(task)
                },
                navigateBack = navigateBack,

                updateDueDate = { dueDate ->
                    viewModel.updateDueDate(dueDate)

                },
                updateDueTime = {dueTime -> viewModel.updateDueTime(dueTime) }
            )
        }
    )
}

