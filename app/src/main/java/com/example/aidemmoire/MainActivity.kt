package com.example.aidemmoire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController


import com.example.aidemmoire.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.aidemmoire.ui.theme.AideMemoireTheme

import com.example.aidemmoire.uiTask.TasksScreen

import dagger.hilt.android.AndroidEntryPoint






@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                AideMemoireTheme {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }


            }
        }

   
}


