package com.example.aidemmoire.navigation

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aidemmoire.uiTask.TasksScreen
import com.example.aidemmoire.uiTask.UpdateTasksScreen
import com.example.aidemmoire.uiTask.CheckedTasksScreen



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
                navigateToCheckedTasksScreen = { navController.navigate(route = Screen.CheckedTasksScreen.route) },

                navigateToUpdateTaskScreen = { taskId ->

                       navController.navigate("${Screen.UpdateTaskScreen.route}/${taskId}")
                })

        }
        composable(
            route = Screen.CheckedTasksScreen.route
        ) {
            CheckedTasksScreen(navigateBack = {
                navController.popBackStack()


            })

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