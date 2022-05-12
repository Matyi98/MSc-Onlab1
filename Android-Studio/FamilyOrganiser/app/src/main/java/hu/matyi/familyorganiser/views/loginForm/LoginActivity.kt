package hu.matyi.familyorganiser.views.loginForm

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.views.familyMenu.FamilyMenuActivity
import hu.matyi.familyorganiser.views.profilSettings.ProfilSettingsActivity
import hu.matyi.familyorganiser.views.registerForm.RegisterActivity
import io.swagger.client.models.LoginDTO


//https://www.youtube.com/watch?v=SZR04TKHDM4&t=257s

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                Screen()
            }
            }
        }
    }
   @Composable
   private fun Screen(loginModel: LoginModel = hiltViewModel()) {
       val context = LocalContext.current
       Scaffold(backgroundColor = Color.White)
       {
           Column(
               Modifier.fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Top
           )
           {
               Image(
                   painter = painterResource(
                       id = R.drawable.family
                   ),
                   contentDescription = "App Theme",
                   modifier = Modifier
                       .weight(0.2f)
                       .fillMaxWidth()
               )
               Card(
                   Modifier
                       .weight(0.8f)
                       .padding(8.dp),
                   shape = RoundedCornerShape(20.dp)
               )
               {
                   Column(
                       Modifier
                           .background(Color(R.color.teal_700))
                           .fillMaxSize()
                           .padding(16.dp)
                   ) {


                       /* Welcom text*/
                       Box(Modifier.weight(0.1f))
                       {
                           welcomText(stringResource(R.string.login_welcome_text))
                       }


                       /*Username, Password fields*/
                       var usrname = "";
                       var passwd = "";
                       Box(Modifier.weight(0.1f))
                       {
                           usrname = basicInputField(stringResource(R.string.username))
                       }
                       Box(Modifier.weight(0.1f))
                       {
                           passwd = passwordField()
                       }
                       loginModel.setLoginLiveDto(LoginDTO(usrname, passwd))


                       /*Login button*/
                       val intent1 = Intent(context, FamilyMenuActivity::class.java)
                       Box(Modifier.weight(0.1f))
                       {
                           basicButton(context, stringResource(R.string.login_button_text), intent1,
                               check = { LoginHandler().sendLoginRequest(loginModel) }) {
                           }
                       }


                       /*Registration button*/
                       Box(Modifier.weight(0.1f))
                       {
                           val intent2 = Intent(context, RegisterActivity::class.java)
                           secondOptionButton(
                               context,
                               stringResource(R.string.registrate_button_text),
                               intent2
                           )
                       }

                       /*Settings button*/
                       Box(Modifier.weight(0.2f))
                       {
                           val intent3 = Intent(context, ProfilSettingsActivity::class.java)
                           settingsButton(context = LocalContext.current, intent = intent3)
                       }
                   }
               }
           }
       }
   }













