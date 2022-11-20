package com.example.aidemmoire.uiTask

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aidemmoire.uiTask.screens.UpdateTaskTopBar
import com.example.aidemmoire.uiTask.screens.UpdateTaskContent


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
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateTaskContent(
                padding = padding,
                task = viewModel.task,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateAuthor = { author ->
                    viewModel.updateDescription(author)
                },
                updateTask = { task ->
                    viewModel.updateTask(task)
                },
                navigateBack = navigateBack
            )
        }
    )
}
