package hu.matyi.familyorganiser.views.registerForm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                RegisterScreen2()
            }
        }
    }
}

@Composable
fun RegisterScreen2() {
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
                    .fillMaxWidth().weight(1f)
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

                    Text(text = "Let's registrate!",
                        fontWeight = FontWeight.Bold,
                        fontSize =  25.sp,
                        modifier = Modifier.fillMaxWidth().padding(20.dp).fillMaxWidth(),
                        color = Color.White)
                    var username by rememberSaveable { mutableStateOf("") }
                    TextField(
                        value =username ,
                        onValueChange = {username = it},
                        modifier = Modifier.fillMaxWidth().padding(20.dp).fillMaxWidth(),
                        label = { Text(text = "Username", fontSize = 25.sp) },
                        trailingIcon =
                        {
                            IconButton(onClick = {})
                        {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                        }
                        })
                    var password by rememberSaveable { mutableStateOf("") }
                    TextField(
                        value = password,
                        onValueChange = {password = it},
                        enabled = true,
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        label = { Text(text = "Password", fontSize = 25.sp) },
                        trailingIcon =
                        {
                            IconButton(onClick = {})
                        {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                        }
                        })
                    TextField(
                        value = password,
                        onValueChange = {password = it},
                        enabled = true,
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        label = { Text(text = "Password(2)", fontSize = 25.sp) },
                        trailingIcon =
                        {
                            IconButton(onClick = {})
                            {
                                Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                            }
                        })
                    Button(
                        onClick = {
                        },
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        //border = BorderStroke(width = 0.dp, brush = SolidColor(Color.Blue)),
                        //shape = MaterialTheme.shapes.medium,
                    )
                    {
                        Text(text = "Registrate", color = Color.White)
                    }

                }
            }
        }
    }
}

