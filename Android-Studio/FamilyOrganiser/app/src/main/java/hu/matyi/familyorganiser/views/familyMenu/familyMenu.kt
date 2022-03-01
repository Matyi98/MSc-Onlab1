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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.loginForm.RegisterScreen
import hu.matyi.familyorganiser.views.registerForm.RegisterActivity

class familyMenu : ComponentActivity() {
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
                    .weight(0.5f).fillMaxWidth()
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

                    Text(text = "You are not yet a member of any family!",
                        fontWeight = FontWeight.Bold,
                        fontSize =  25.sp,
                        modifier = Modifier.fillMaxWidth().padding(30.dp).fillMaxWidth(),
                        color = Color.White)
                    var username by rememberSaveable { mutableStateOf("") }
                    var familySecretCode by rememberSaveable { mutableStateOf("") }
                    TextField(
                        value = familySecretCode,
                        onValueChange = {familySecretCode = it},
                        enabled = true,
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        label = { Text(text = "Family code:", fontSize = 25.sp) },
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
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                        shape = MaterialTheme.shapes.medium,
                    )
                    {
                        Text(text = "Join", color = Color.White)
                    }
                    Button(
                        onClick = {
                            val intent = Intent(context, RegisterActivity::class.java)
                            context.startActivity(intent)
                        },
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(R.color.teal_700)),
                        //border = BorderStroke(width = 0.dp, brush = SolidColor(Color.Blue)),
                        //shape = MaterialTheme.shapes.medium,
                    )
                    {
                        Text(text = "Create your family", color = Color.White)
                    }

                }
            }
        }
    }
}



