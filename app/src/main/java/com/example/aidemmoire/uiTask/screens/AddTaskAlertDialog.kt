package com.example.aidemmoire.uiTask.screens



import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidemmoire.R
import com.example.aidemmoire.data.Task
import kotlinx.coroutines.job
import java.util.*


@Composable
fun AddTaskAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addTask: (task: Task) -> Unit
) {
    if (openDialog) {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var dueDate by remember { mutableStateOf("") }
        val mYear: Int
        val mMonth: Int
        val mDay: Int
        val mCalendar = Calendar.getInstance()
        val mDate = remember { mutableStateOf("") }
        // Fetching current year, month and day
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
        val mContext = LocalContext.current
        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                dueDate = "$mDayOfMonth/${mMonth+1}/$mYear"
            }, mYear, mMonth, mDay
        )


        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = stringResource(R.string.add_task)
                )
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = stringResource(R.string.task_title)
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        placeholder = {
                            Text(
                                text = stringResource(R.string.task_description)
                            )
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    SelectableTextField(
                        textValue = dueDate,
                        onClick={ mDatePickerDialog.show()  }

                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val task = Task(0, title, description,dueDate)
                        addTask(task)
                    }
                ) {
                    Text(
                        text = "Add"
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = "Dismiss"
                    )
                }
            }
        )
    }
}
@Composable
fun SelectableTextField(
    modifier: Modifier = Modifier,
    textValue: String,

    onClick: () -> Unit
) {
    TextField(
        value = textValue,
        onValueChange = {  },
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        enabled = false
    )
}