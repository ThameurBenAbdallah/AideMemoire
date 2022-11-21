package com.example.aidemmoire.uiTask.screens

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.aidemmoire.R

@Composable
fun TasksTopBar () {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.all_tasks)
                            )
    }
            )
        }

