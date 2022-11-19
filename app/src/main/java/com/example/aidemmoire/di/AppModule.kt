package com.example.aidemmoire.di

import android.content.Context
import androidx.room.Room
import com.example.aidemmoire.data.TaskDao
import com.example.aidemmoire.data.TaskRepository
import com.example.aidemmoire.data.TaskRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


    @Module
    @InstallIn(SingletonComponent::class)
    class AppModule {
        @Provides
        fun provideTaskDb(
            @ApplicationContext
            context: Context
        ) = Room.databaseBuilder(
            context,
            TaskRoomDatabase::class.java,
            "item_database"
        ).build()

        @Provides
        fun provideTaskDao(
            taskDb: TaskRoomDatabase
        ) = taskDb.taskDao()

        @Provides
        fun provideTaskRepository(
            taskDao: TaskDao
        ): TaskRepository = TaskRepository(
            taskDao = taskDao
        )

    }
