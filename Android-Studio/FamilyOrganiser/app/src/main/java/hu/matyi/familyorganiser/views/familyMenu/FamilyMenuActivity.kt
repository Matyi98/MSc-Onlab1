package hu.matyi.familyorganiser.views.familyMenu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.createFamilyForm.CreateFamilyActivity
import hu.matyi.familyorganiser.views.profilSettings.ProfilSettingsActivity

class FamilyMenuActivity : ComponentActivity() {
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
private fun Screen() {
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
                    secondOptionButton(context = context, text = stringResource(R.string.familyCreate_button_text), intent)
                    val intent1 = Intent(context, ProfilSettingsActivity::class.java)
                    settingsButton(context = context,  intent = intent1)
                }
            }
        }
    }

}





