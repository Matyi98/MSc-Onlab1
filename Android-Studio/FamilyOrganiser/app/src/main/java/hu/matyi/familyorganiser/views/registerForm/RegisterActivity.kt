package hu.matyi.familyorganiser.views.registerForm

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.loginForm.LoginActivity
import hu.matyi.familyorganiser.views.loginForm.LoginHandler
import io.swagger.client.models.RegistrationDTO

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
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
private fun Screen(registerModel : RegisterModel = hiltViewModel()) {
    val context = LocalContext.current
    Scaffold(backgroundColor = Color.White)
    {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top)
        {
            Image(painter = painterResource(
                id = R.drawable.register),
                contentDescription = "App Theme",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
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
                    welcomText(text = stringResource(R.string.registrate_welcome_text))
                    var username = basicInputField(stringResource(R.string.username))
                    var password = passwordField()
                    registerModel.setRegisterLiveDto(RegistrationDTO(LoginHandler.UID?:"",username, password))
                    val intent = Intent(context, LoginActivity::class.java)
                    basicButton(context = LocalContext.current, text =  stringResource(R.string.registrate), intent, check = { RegistrationHandler().sendRegistrationRequest(registerModel) })

                }
            }
        }
    }
}

