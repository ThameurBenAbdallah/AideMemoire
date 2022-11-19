package com.example.aidemmoire.data

import kotlinx.coroutines.flow.Flow

typealias Tasks = List<Task>

interface TaskRepositoryInterface {




        fun geTasksFromRoom(): Flow<Tasks>

        fun getTaskFromRoom(id: Int): Task

        fun addTaskToRoom(task: Task)

        fun updateTask(task: Task)

        fun deleteTask(task: Task)

}