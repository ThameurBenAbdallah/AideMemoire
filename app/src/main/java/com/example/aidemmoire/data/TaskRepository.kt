package com.example.aidemmoire.data
import com.example.aidemmoire.data.TaskDao
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao): TaskRepositoryInterface {

    override fun geTasksFromRoom() = taskDao.getAllTasks()


    override fun addTaskToRoom(task:Task) = taskDao.insert(task)



    override fun getTaskFromRoom(id:Int): Task = taskDao.getTaskFromRoom(id)
    override fun deleteTask(task:Task)= taskDao.delete(task)

    override fun updateTask(task: Task) = taskDao.update(task)



}