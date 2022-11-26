package com.example.aidemmoire.uiTask.uiComponents


import android.service.autofill.OnClickAction
import android.util.Log
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar



import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            ClickableRow(onClickAction = navigateToCheckedTasksScreen)

        }

   )
}
@Composable
fun ClickableRow(onClickAction: () -> Unit,
                 modifier: Modifier = Modifier,){
    Row (verticalAlignment = Alignment.CenterVertically){
        IconButton(onClick = {onClickAction
            Log.d("tham", "nav clicked")
        }) {

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_check_24),
                contentDescription = "See finished tasks"
            )


        }
        Text("Done tasks", modifier = modifier
            .clickable { onClickAction })
    }

}