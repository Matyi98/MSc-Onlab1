package hu.matyi.familyorganiser.views.loginForm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.views.familyMenu.FamilyMenuActivity
import hu.matyi.familyorganiser.views.registerForm.RegisterActivity

//https://www.youtube.com/watch?v=SZR04TKHDM4&t=257s
class LoginActivity : ComponentActivity() {
    private var loginHandler : LoginHandler = LoginHandler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                Screen(loginHandler)
            }
            }
        }
    }
   @Composable
   private fun Screen(loginHandler: LoginHandler) {
       val context = LocalContext.current
       Scaffold(backgroundColor = Color.White)
       {
           Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
           {
                Image(painter = painterResource(
                    id = R.drawable.family),
                    contentDescription = "App Theme",
                    modifier = Modifier
                        .weight(1f).fillMaxWidth()
                )
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

                       welcomText(stringResource(R.string.login_welcome_text))
                       loginHandler.setUsername(basicInputField(stringResource(R.string.username)))
                       loginHandler.setPassword(passwordField())
                       val intent1 = Intent(context, FamilyMenuActivity::class.java)
                       basicButton(context, stringResource(R.string.login_button_text), intent1) { loginHandler.sendLoginRequest() }
                       val intent2 = Intent(context, RegisterActivity::class.java )
                       secondOptionButton(context, stringResource(R.string.registrate_button_text),intent2)

                   }
               }
           }
       }
   }












