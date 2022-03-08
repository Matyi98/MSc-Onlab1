package hu.matyi.familyorganiser.views.familyMainView

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.basicButton
import hu.matyi.familyorganiser.components.basicInputField
import hu.matyi.familyorganiser.components.welcomText
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.createFamilyForm.CreateFamilyActivity

class familyMainView: ComponentActivity()  {
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
        Row(Modifier.fillMaxSize())
        {
            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp)
            )
            {
                Column(Modifier.fillMaxSize())
                {
                    memberListTitle()
                    Card(
                        Modifier
                            .weight(1f)
                            .padding(8.dp),
                    shape = RoundedCornerShape(32.dp)
                    )
                    {
                        Row()
                        {
                            RectangleShape
                            TextField(value = "Kis Pista", onValueChange = {})
                        }
                    }
                    Card(
                        Modifier
                            .weight(1f)
                            .padding(8.dp),
                        shape = RoundedCornerShape(32.dp)
                    )
                    {
                        Row()
                        {
                            TextField(value = "Kis Pistané", onValueChange = {})
                        }
                    }
                }
            }
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
                    welcomText(text = stringResource(R.string.familymenu_welcome_text))
                    val familyCode = basicInputField(text = stringResource(R.string.familyCode))
                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        enabled = true,
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                        shape = MaterialTheme.shapes.medium,
                    )
                    {
                        Text(text = "Join", color = Color.White)
                    }
                    val intent = Intent(context, CreateFamilyActivity::class.java)
                    basicButton(
                        context = context,
                        text = stringResource(R.string.familyCreate_button_text),
                        intent
                    )
                }

            }
        }
    }
}

@Composable
fun memberListTitle() {
    Text(
        text = stringResource(R.string.Members),
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .fillMaxWidth(),
        color = Color.White
    )
}