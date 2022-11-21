package com.example.aidemmoire.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aidemmoire.uiTask.TasksScreen
import com.example.aidemmoire.uiTask.UpdateTasksScreen



@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.TasksScreen.route
    ) {
        composable(
            route = Screen.TasksScreen.route
        ) {
            TasksScreen(
                navigateToUpdateTaskScreen = { taskId ->

                    navController.navigate("${Screen.UpdateTaskScreen.route}/${taskId}")
                }
            )
        }
        composable(
            route = "${Screen.UpdateTaskScreen.route}/{taskId}",
            arguments = listOf(
                navArgument("taskId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: 0
            UpdateTasksScreen(
                taskId = taskId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}