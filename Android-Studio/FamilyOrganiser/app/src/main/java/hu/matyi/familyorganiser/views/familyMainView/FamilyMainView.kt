package hu.matyi.familyorganiser.views.familyMainView

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





class FamilyMainView: ComponentActivity()  {
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
    val prefs: SharedPreferences = context.getSharedPreferences("ProfilPreference", MODE_PRIVATE)
    val surname = prefs.getString("surname", "Blank Name") //"Blank Name" the default value.
    val lastname = prefs.getString("lastname", "Blank Name")
    val email = prefs.getString("email", "Blank Mail")
    val birthday = prefs.getString("birthday", "Blank Date")

    val idName = prefs.getInt("id", 0) // 0 is the default value.

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
                            surname?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                            lastname?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                            birthday?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                            email?.let { it1 -> TextField(value = it1, onValueChange = {}) }
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
                    .weight(2.3f)
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
                    welcomText(text = stringResource(R.string.Hello) + lastname)
                    noEffectButton(text = "Shopping")
                    noEffectButton(text = "Events")
                    var file = File(context.filesDir,"familyPhoto")
                    var stringToBitmap : String =
                        file.inputStream().readBytes().toString(Charsets.UTF_8)
                    val bitmap = StringToBitMap(stringToBitmap)
                    if (bitmap != null) {
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )

                    }

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

/*private fun readFromFile(fileName: String, context: Context): InputStream? {
    var ret = ""
    //try {
        val inputStream: InputStream? = context.openFileInput(fileName)
        if (inputStream != null) {
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            var receiveString: String? = ""
            val stringBuilder = StringBuilder()
            while (bufferedReader.readLine().also { receiveString = it } != null) {
                stringBuilder.append("\n").append(receiveString)
           // }
            /*inputStream.close()
            ret = stringBuilder.toString()
        }
    } catch (e: FileNotFoundException) {
        Log.e("login activity", "File not found: $e")
    } catch (e: IOException) {
        Log.e("login activity", "Can not read file: $e")*/
    }
    return inputStream
}*/