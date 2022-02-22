package hu.matyi.familyorganiser

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                SignInScreen()
            }
            }
        }
    }

   @Composable
   fun SignInScreen() {
       Scaffold(backgroundColor = Color.White)
       {
           Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
           {
                Image(painter = painterResource(
                    id = R.drawable.family),
                    contentDescription = "App Theme",
                    modifier = Modifier
                        .weight(1f)
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

                       Text(text = "Welcome Back!",
                           fontWeight = FontWeight.Bold,
                           fontSize =  25.sp,
                           modifier = Modifier.fillMaxWidth().padding(20.dp).fillMaxWidth(),
                           color = Color.White)
                       TextField(
                           value ="" ,
                           onValueChange = {},
                           modifier = Modifier.fillMaxWidth().padding(20.dp).fillMaxWidth(),
                           label = {Text(text = "Username", fontSize = 25.sp)},
                       trailingIcon =
                       {IconButton(onClick = {})
                       {
                           Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                       }
                       })
                       TextField(
                           value ="" ,
                           onValueChange = {},
                           modifier = Modifier.fillMaxWidth().padding(20.dp),
                           label = {Text(text = "Password", fontSize = 25.sp)},
                           trailingIcon =
                           {IconButton(onClick = {})
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
                           Text(text = "Log in", color = Color.White)
                       }
                       Button(
                           onClick = {
                           },
                           modifier = Modifier.fillMaxWidth().padding(20.dp),
                           enabled = true,
                           border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                           shape = MaterialTheme.shapes.medium,
                       )
                       {
                           Text(text = "Not yet registered?", color = Color.White)
                       }

                   }
               }
           }
       }
   }


