package hu.matyi.familyorganiser.views.familyMenu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.basicButton
import hu.matyi.familyorganiser.components.basicInputField
import hu.matyi.familyorganiser.components.noEffectButton
import hu.matyi.familyorganiser.components.welcomText
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.createFamilyForm.CreateFamilyActivity
import hu.matyi.familyorganiser.views.loginForm.LoginActivity
import hu.matyi.familyorganiser.views.registerForm.RegisterActivity

class FamilyMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                RegisterScreen3()
            }
        }
    }
}

@Composable
fun RegisterScreen3() {
    val context = LocalContext.current
    Scaffold(backgroundColor = Color.White)
    {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
        {
            Image(painter = painterResource(
                id = R.drawable.family),
                contentDescription = "App Theme",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
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
                    //welcomText(text = stringResource(R.string.familymenu_welcome_text))
                    welcomText(text = stringResource(R.string.familymenu_welcome_text))
                    val familyCode = basicInputField(text = stringResource(R.string.familyCode))
                    noEffectButton("Join")
                    val intent = Intent(context, CreateFamilyActivity::class.java)
                    basicButton(context = context, text = stringResource(R.string.familyCreate_button_text), intent)
                }
            }
        }
    }
}





