package hu.matyi.familyorganiser.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

//https://www.geeksforgeeks.org/date-picker-in-android-using-jetpack-compose/

@Composable
fun datePickerField(text: String = "Birthday") : String {

    //FFF
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    val mDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )

    //fff

    var date by rememberSaveable { mutableStateOf("") }
    TextField(
        value = date,
        onValueChange = { date = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .fillMaxWidth(),
        label = { Text(text = text, fontSize = 15.sp) },
        trailingIcon =
        {
            IconButton(onClick = {
                mDatePickerDialog.show()
            })
            {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "")
            }
        })
    date = mDate.value
    return date
}

