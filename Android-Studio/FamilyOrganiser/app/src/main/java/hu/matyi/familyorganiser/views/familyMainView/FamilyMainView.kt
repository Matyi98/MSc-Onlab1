package hu.matyi.familyorganiser.views.familyMainView

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.welcomText
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import android.graphics.Bitmap
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.ui.graphics.asImageBitmap
import hu.matyi.familyorganiser.components.basicButton
import hu.matyi.familyorganiser.components.noEffectButton
import java.io.*
import java.lang.Exception
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import android.view.Gravity
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.pager.*
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.android.material.animation.AnimationUtils.lerp
import kotlin.math.absoluteValue

//https://google.github.io/accompanist/pager/
class FamilyMainView: ComponentActivity()  {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                Screen()
            }
        }
    }

}

typealias ComposableFun = @Composable () -> Unit

@SuppressLint("RestrictedApi")
@ExperimentalPagerApi
@Composable
private fun Screen() {
    val context = LocalContext.current
    val prefs: SharedPreferences = context.getSharedPreferences("ProfilPreference", MODE_PRIVATE)
    val surname = prefs.getString("surname", "Blank Name")
    val lastname = prefs.getString("lastname", "Blank Name")
    val email = prefs.getString("email", "Blank Mail")
    val birthday = prefs.getString("birthday", "Blank Date")
    val selectedItem = remember { mutableStateOf("upload")}

    Scaffold(bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary,
        content = {

            BottomNavigation() {
                BottomNavigationItem(
                    icon = {
                        Icon(Icons.Filled.Favorite , "")
                    },
                    label = { Text(text = "Favorite")},
                    selected = selectedItem.value == "favorite",
                    onClick = {
                        //result.value = "Favorite icon clicked"
                        selectedItem.value = "favorite"
                    },
                    alwaysShowLabel = false
                )

                BottomNavigationItem(
                    icon = {
                        Icon(Icons.Filled.Save , "")
                    },
                    label = { Text(text = "Save")},
                    selected = selectedItem.value == "save",
                    onClick = {
                        //result.value = "Save icon clicked"
                        selectedItem.value = "save"
                    },
                    alwaysShowLabel = false
                )

                BottomNavigationItem(
                    icon = {
                        Icon(Icons.Filled.Upload ,  "")
                    },


                    label = { Text(text = "Upload")},
                    selected = selectedItem.value == "upload",
                    onClick = {
                        //result.value = "Upload icon clicked"
                        selectedItem.value = "upload"
                    },
                    alwaysShowLabel = false
                )

            }


        }
    ) }
    ) {
        HorizontalPager(2
        ) { page ->
            when(page)
            {
                0 -> helloCard(context = context, surname = surname)
                1 -> memberListCard(surname = surname, lastname = lastname, birthday = birthday, email = email)
            }
        }
    }
}

@Composable
private fun memberListCard(
    surname: String?,
    lastname: String?,
    birthday: String?,
    email: String?
) {
    Card(
        Modifier.Companion
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
                    .padding(10.dp),
                //shape = RoundedCornerShape(32.dp)
            )
            {
                Column(Modifier.fillMaxSize()) {
                    surname?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                    lastname?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                    birthday?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                    email?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                }
            }
        }
    }
}

@Composable
private fun helloCard(context: Context, surname: String?) {
        Card(
            Modifier.Companion
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
                var file = File(context.filesDir, "familyPhoto")
                var stringToBitmap: String =
                    file.inputStream().readBytes().toString(Charsets.UTF_8)
                val bitmap = StringToBitMap(stringToBitmap)
                if (bitmap != null) {
                    Card(
                        modifier = Modifier.size(150.dp),
                        shape = CircleShape,
                        elevation = 2.dp
                    ) {
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(70.dp)
                                .clip(CircleShape)                       // clip to the circle shape
                                .border(2.dp, Color.Gray, CircleShape)
                        )
                    }
                    welcomText(text = stringResource(R.string.Hello) + " " + surname)
                    noEffectButton(text = "Shopping")
                    noEffectButton(text = "Events")
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

//https://www.android--code.com/2020/06/android-kotlin-bitmap-to-base64-string.html
public fun Context.assetsToBitmap(fileName:String):Bitmap?{
    return try {
        val stream = assets.open(fileName)
        BitmapFactory.decodeStream(stream)
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}

fun StringToBitMap(encodedString: String?): Bitmap? {
    return try {
        val encodeByte =
            Base64.decode(encodedString, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
    } catch (e: Exception) {
        e.message
        null
    }
}
