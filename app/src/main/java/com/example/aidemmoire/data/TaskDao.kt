package com.example.aidemmoire.data


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)
    @Update
    fun update(task: Task)
    @Delete
    fun delete(task: Task)
    @Query("SELECT * FROM task_todo ORDER BY title ASC")
    fun getAllTasks(): Flow<List<Task>>
    @Query("SELECT * FROM task_todo WHERE id = :id")
    fun getTaskFromRoom(id:Int): Task
}