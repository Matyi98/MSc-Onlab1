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
import hu.matyi.familyorganiser.views.loginForm.LoginActivity
import hu.matyi.familyorganiser.views.loginForm.LoginHandler
import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter


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
                    ProfilModel.createFamilyMember.firstName = basicInputField(text = "Surname")
                    ProfilModel.createFamilyMember.lastName = basicInputField(text = "Lastname")
                    ProfilModel.createFamilyMember.email = basicInputField(text = "Email")
                    var stringDate = datePickerField()
                    var localDateDate = LocalDate.now()
                    try {
                        localDateDate =  LocalDate.parse(stringDate, DateTimeFormatter.BASIC_ISO_DATE)
                    }catch (e :Exception){}

                    ProfilModel.createFamilyMember.birthDate = localDateDate
                    val editor: SharedPreferences.Editor =
                        context.getSharedPreferences("ProfilPreference", MODE_PRIVATE).edit()

                        val intent1 = Intent(context, LoginActivity::class.java)
                        basicButton(context = context, text = stringResource(R.string.save_and_exit), intent = intent1, extraFunction = {
                            editor.putString("surname", ProfilModel.createFamilyMember.firstName)
                            editor.putString("lastname", ProfilModel.createFamilyMember.lastName)
                            editor.putString("birthday", stringDate)
                            editor.putString("email", ProfilModel.createFamilyMember.email)
                            editor.apply()
                            ProfilSettingsHandler().ProfilSettingsHandler()
                        })
                        basicButton(context = context, text = stringResource(R.string.cancel), intent = intent1 )
                    }
                }
            }
        }
    }

