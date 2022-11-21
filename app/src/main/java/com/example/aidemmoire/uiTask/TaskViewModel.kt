package com.example.aidemmoire.uiTask

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidemmoire.data.Task
import com.example.aidemmoire.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val repos: TaskRepository) : ViewModel() {


    private var _task by mutableStateOf(Task(0,"","","",""))
    val task : Task
    get()=_task

    var openDialog by mutableStateOf(false)
    val tasks = repos.geTasksFromRoom()
    /*
    private var _allTasks = repos.allTasks.stateIn(this.viewModelScope, SharingStarted.Eagerly, emptyList())
    val allTask = _allTasks*/


    fun getTask(id: Int) {
        viewModelScope.launch(Dispatchers.IO)  {
            _task = repos.getTaskFromRoom(id)
            /*repos.getTaskFromRoom(id).collect { response ->
                task = response*/
            }


        }

    fun addTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repos.addTaskToRoom(task)
        }
    }
    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repos.updateTask(task)
    }
    fun deleteTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repos.deleteTask(task)
        }
    }
    fun updateTitle(title: String) {
        _task = task.copy(
            title = title
        )
    }
    fun updateDescription(description: String){
        _task = task.copy(
            description = description        )
    }
    fun closeDialog() {
        openDialog = false
    }
    fun openDialog() {
        openDialog = true
    }


}

/*
class TaskViewModelFactory(private val repo: TaskRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass:Class<T>): T{
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}*/