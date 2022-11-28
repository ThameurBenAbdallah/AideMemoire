package com.example.aidemmoire.uiTask.uiComponents


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.DecimalFormat
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
    addTask: (task: Task) -> Unit,
) {
    if (openDialog) {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var dueDate by remember { mutableStateOf("") }
        var dueTime by remember {
            mutableStateOf("")
        }
        val mYear: Int
        val mMonth: Int
        val mDay: Int
        val mHour: Int
        val mMinute: Int
        val mCalendar = Calendar.getInstance()
        // Fetching current year, month and day
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
        mHour = mCalendar.get(Calendar.HOUR_OF_DAY)
        mMinute = mCalendar.get(Calendar.MINUTE)
        val mContext = LocalContext.current

        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                dueDate = "$mDayOfMonth/${mMonth + 1}/$mYear"
            }, mYear, mMonth, mDay
        )
        val mTimePickerDialog = TimePickerDialog(
            mContext,
            { _: TimePicker, mHour: Int, mMinute: Int ->
                dueTime = mHour.toString().padStart(2, '0').toString() + ":" + mMinute.toString()
                    .padStart(2, '0').toString()
                Log.d("tham", dueTime)
            }, mHour, mMinute, true
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
                    SelectablePicker(
                        textValue = dueDate,
                        onClick = { mDatePickerDialog.show() },
                        Icon = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null
                            )
                        },

                        placeHolderText = ""


                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    SelectablePicker(
                        textValue = dueTime,
                        onClick = { mTimePickerDialog.show() },
                        Icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_schedule_24),
                                contentDescription = null
                            )
                        },

                        placeHolderText = ""


                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {

                        if (title == "") {
                            Toast.makeText(mContext, "A task must have a title", Toast.LENGTH_SHORT)
                                .show()

                        }
                        if (dueDate == "") {
                            Toast.makeText(mContext,
                                "A task must have a deadline date",
                                Toast.LENGTH_SHORT).show()
                        } else {
                            closeDialog()
                            val task = Task(0, title, description, dueDate, dueTime, false)
                            addTask(task)
                        }
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



