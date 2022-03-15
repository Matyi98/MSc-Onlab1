package hu.matyi.familyorganiser.views.createFamilyForm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Redo
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.*
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.familyMainView.FamilyMainView


class CreateFamilyActivity : ComponentActivity() {
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
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
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
                        .padding(32.dp)
                ) {
                    welcomText(text = stringResource(R.string.create_family_welcome_text))
                    val familyCode = randomTextInputField(stringResource(R.string.familyCode))
                    val familyName = basicInputField(text = stringResource(R.string.family_name))
                    val image = imagePicker()
                    val familyMainMenuIntent = Intent(context, FamilyMainView::class.java)
                    familyMainMenuIntent.putExtra("FamilyName",familyName)
                    familyMainMenuIntent.putExtra("FamilyCode",familyCode)
                    basicButton(context = context, text = "Create", familyMainMenuIntent)
                }
            }
        }
    }
}

