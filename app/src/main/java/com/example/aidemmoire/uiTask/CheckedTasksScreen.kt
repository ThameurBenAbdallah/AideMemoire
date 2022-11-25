package com.example.aidemmoire.uiTask



import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aidemmoire.R
import com.example.aidemmoire.uiTask.screens.*

@Composable
@ExperimentalMaterialApi
fun CheckedTasksScreen(

    viewModel: TaskViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    val tasks by viewModel.tasks.collectAsState(initial = emptyList())




    Scaffold(
        topBar = {
            UpdateTaskTopBar(navigateBack = navigateBack,
                R.string.checked_tasks
            )
        },
        content = { padding ->
            FinishedTasksContent(
                padding = padding,
                tasks = tasks,
                deleteTask = {  },
                navigateToUpdateTaskScreen = {  },
                unSetTaskCompleted =  {task -> viewModel.unSetTaskCompleted(task)},



            )

        },

    )
}




