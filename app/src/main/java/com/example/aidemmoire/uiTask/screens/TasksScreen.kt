package com.example.aidemmoire.uiTask.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aidemmoire.R
import com.example.aidemmoire.uiTask.TaskViewModel
import com.example.aidemmoire.uiTask.uiComponents.*


@Composable
@ExperimentalMaterialApi
fun TasksScreen(

    navigateToUpdateTaskScreen: (taskId: Int) -> Unit,
    viewModel: TaskViewModel = hiltViewModel(),
    navController: NavController,
) {

    val tasks by viewModel.tasks.collectAsState(initial = emptyList())




    Scaffold(
        topBar = {


            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.all_tasks)
                    )
                },
                actions = {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {
                            navController.navigate("CheckedTasks")
                        })
                        {

                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_check_24),
                                contentDescription = "See finished tasks"
                            )

                        }
                        Text("Done tasks", modifier = Modifier
                            .clickable { navController.navigate("CheckedTasks") })
                    }

                }
            )

        },
        content = { padding ->
            TasksContent(
                padding = padding,
                tasks = tasks,
                deleteTask = { task ->
                    viewModel.deleteTask(task)
                },
                navigateToUpdateTaskScreen = navigateToUpdateTaskScreen,
                setTaskCompleted = { task -> viewModel.setTaskCompleted(task) }
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
        },
    )
}




