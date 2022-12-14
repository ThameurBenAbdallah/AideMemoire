package com.example.aidemmoire.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "task_todo")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo (name = "title" )
    val title: String,
    @ColumnInfo (name = "description" )
    val description: String,

    @ColumnInfo (name = "due_date" )
    val dueDate: String,
    @ColumnInfo (name = "due_time" )
    val dueTime: String,
    @ColumnInfo (name = "is_competed")
    val isCompleted : Boolean

    )
