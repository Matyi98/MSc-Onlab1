package hu.matyi.familyorganiser.views.profilSettings

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.android.material.datepicker.MaterialDatePicker
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.createFamilyForm.CreateFamilyActivity
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import hu.matyi.familyorganiser.views.familyMenu.FamilyMenuActivity


class ProfilSettings: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                Screen()
            }
        }
    }
}

@SuppressLint("CommitPrefEdits")
@Composable
private fun Screen() {
    val context = LocalContext.current
    Scaffold(backgroundColor = Color.White)
    {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
        {
            Card(
                Modifier
                    .weight(2f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp)
            )
            {
                Column(
                    Modifier
                        .background(Color(R.color.teal_700))
                        .fillMaxSize()
                        .padding(32.dp)) {
                    welcomText(stringResource(R.string.profilsettings_welcome_text))
                    val surname = basicInputField(text = "Surname")
                    val lastname = basicInputField(text = "Lastname")
                    val email = basicInputField(text = "Email")
                    val birthday = datePickerField()
                    val editor: SharedPreferences.Editor =
                        context.getSharedPreferences("ProfilPreference", MODE_PRIVATE).edit()

                        val intent1 = Intent(context, FamilyMenuActivity::class.java)
                        basicButton(context = context, text = stringResource(R.string.save_and_exit), intent = intent1, extraFunction = {
                            editor.putString("surname", surname)
                            editor.putString("lastname", lastname)
                            editor.putString("birthday", birthday)
                            editor.putString("email", email)
                            editor.apply()
                        })
                        basicButton(context = context, text = stringResource(R.string.cancel), intent = intent1 )
                    }
                }
            }
        }
    }