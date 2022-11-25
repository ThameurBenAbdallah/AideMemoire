package com.example.aidemmoire.uiTask.screens


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Check


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.aidemmoire.R

@Composable
fun TasksTopBar (screenTitle:Int, navigateToCheckedTasksScreen: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(screenTitle)
            )
        },
        actions = {
            IconButton(onClick = { navigateToCheckedTasksScreen
                Log.d("tham","nav cicked")}){

                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_check_24),
                    contentDescription = "See finished tasks"
                )


        }


        }

   )
}