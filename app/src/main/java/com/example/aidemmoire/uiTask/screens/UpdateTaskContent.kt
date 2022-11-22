package com.example.aidemmoire.uiTask.screens





import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aidemmoire.R
import com.example.aidemmoire.data.Task
import java.util.*

@Composable
fun UpdateTaskContent(
    padding: PaddingValues,
    task: Task,
    updateTitle: (title: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateTask: (task: Task) -> Unit,

    navigateBack: () -> Unit,
    updateDueDate: (dueDate: String) -> Unit,
    updateDueTime: (dueTime: String) -> Unit,
) {
    var dueDate by remember { mutableStateOf("") }
    var dueTime by remember {
        mutableStateOf("")
    }
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mHour: Int
    val mMinute:Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mHour=mCalendar.get(Calendar.HOUR_OF_DAY)
    mMinute=mCalendar.get(Calendar.MINUTE)
    val mContext = LocalContext.current
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            dueDate = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        { _: TimePicker, mHour: Int, mMinute: Int ->
            dueTime = "$mHour:${mMinute}"
        }, mHour, mMinute,true
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = task.title,

            readOnly = false,
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(
                    text = task.title
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = task.description,
            onValueChange = { description ->
                updateDescription(description)
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.task_description)
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        SelectablePicker(
            textValue = dueDate,
            onClick={ mDatePickerDialog.show()  },
            Icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
            }

        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        SelectablePicker(
            textValue = dueTime,
            onClick={ mTimePickerDialog.show()  },
            Icon = {
                Icon(
                    painter = painterResource(id =R.drawable.ic_baseline_schedule_24 ),
                    contentDescription = null
                )
            }

        )

        Button(
            onClick = {

                updateDueDate(dueDate)
                updateDueTime(dueTime)
                updateTask(task)

                navigateBack()
            }
        ) {
            Text(
                text = stringResource(R.string.update)
            )
        }
    }
}