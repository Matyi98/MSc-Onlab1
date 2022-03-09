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
import hu.matyi.familyorganiser.components.basicButton
import hu.matyi.familyorganiser.components.basicInputField
import hu.matyi.familyorganiser.components.imagePicker
import hu.matyi.familyorganiser.components.welcomText
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.familyMainView.FamilyMainView
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.view.View
import androidx.core.content.edit
import android.preference.PreferenceManager
import android.util.Base64
import java.io.ByteArrayOutputStream


class CreateFamilyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                RegisterScreen4()
            }
        }
    }
}

@Composable
fun RegisterScreen4() {
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

@Composable
 fun randomTextInputField(text: String) : String {
    var code by rememberSaveable { mutableStateOf("") }
    TextField(
        value = code,
        onValueChange = {  },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .fillMaxWidth(),
        label = { Text(text = text, fontSize = 25.sp) },
        trailingIcon =
        {
            IconButton(onClick = {
                code = getRandomString(10)
            })
            {
                Icon(imageVector = Icons.Filled.Redo , contentDescription = "")
            }
        })
    return code
}

fun getRandomString(length: Int) : String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}

