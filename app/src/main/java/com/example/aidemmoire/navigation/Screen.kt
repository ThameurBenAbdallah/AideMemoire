package com.example.aidemmoire.navigation


sealed class Screen(val route: String) {
    object TasksScreen: Screen("Tasks")
    object UpdateTaskScreen: Screen("UpdateTask")
    object CheckedTasksScreen: Screen("CheckedTasks")
}
