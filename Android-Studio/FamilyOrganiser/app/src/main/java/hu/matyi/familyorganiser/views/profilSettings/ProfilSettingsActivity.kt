package hu.matyi.familyorganiser.views.profilSettings

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import hu.matyi.familyorganiser.views.loginForm.LoginActivity
import hu.matyi.familyorganiser.views.loginForm.LoginModel
import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.FamilyMemberGet
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class ProfilSettingsActivity: AppCompatActivity() {
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
private fun Screen(profilModel: ProfilModel = hiltViewModel()) {
    val context = LocalContext.current
    Scaffold(backgroundColor = Color.White)
    {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
        {
            Card(
                Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(20.dp)
            )
            {
                Column(
                    Modifier
                        .background(Color(R.color.teal_700))
                        .fillMaxSize()
                        .padding(16.dp)) {

                    /* welcome text*/
                    welcomText(stringResource(R.string.profilsettings_welcome_text))


                    /* first name, second name, email, date inputs*/
                    var firstName = ""
                    Box(Modifier.weight(0.167f))
                    {
                        firstName = basicInputField(text = "Firstname")
                    }
                    var lastName = ""
                    Box(Modifier.weight(0.167f))
                    {
                        lastName = basicInputField(text = "Lastname")
                    }
                    var email = ""
                    Box(Modifier.weight(0.167f))
                    {
                        email = basicInputField(text = "Email")
                    }
                    var stringDate = ""
                    Box(Modifier.weight(0.167f))
                    {
                        stringDate = datePickerField()
                    }

                    /* try to convert the string date to date*/
                    var localDateDate = LocalDate.now()
                    try {
                        localDateDate =  LocalDate.parse(stringDate, DateTimeFormatter.BASIC_ISO_DATE)
                    }catch (e :Exception){}

                    /* Put the data to shared pref*/
                    val editor: SharedPreferences.Editor =
                        context.getSharedPreferences("ProfilPreference", MODE_PRIVATE).edit()
                    profilModel.setcreateFamilyMemberLiveDto(CreateFamilyMember(firstName,lastName, email, null, localDateDate,0))
                        val intent1 = Intent(context, LoginActivity::class.java)


                    /* after the button clicked*/
                    Box(Modifier.weight(0.167f))
                    {
                        basicButton(
                            context = context,
                            text = stringResource(R.string.save_and_exit),
                            intent = intent1,
                            extraFunction = {
                                editor.putString("surname", firstName)
                                editor.putString("lastname", lastName)
                                editor.putString("birthday", stringDate)
                                editor.putString("email", email)
                                editor.apply()
                                ProfilSettingsHandler().sendProfilSettingsRequest(profilModel)
                            })
                    }


                    /* or don't put it to the sharedPref but drop it*/
                    Box(Modifier.weight(0.167f))
                    {
                        basicButton(
                            context = context,
                            text = stringResource(R.string.cancel),
                            intent = intent1
                        )
                    }
                }
            }
        }
    }
}

