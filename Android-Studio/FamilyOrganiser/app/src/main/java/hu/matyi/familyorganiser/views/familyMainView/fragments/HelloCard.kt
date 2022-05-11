package hu.matyi.familyorganiser.views.familyMainView.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.settingsButton
import hu.matyi.familyorganiser.components.welcomText
import hu.matyi.familyorganiser.views.profilSettings.ProfilSettingsActivity
import java.io.File
import java.io.IOException

@Composable
fun helloCard(context: Context, surname: String?) {
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
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var file = File(context.filesDir, "familyPhoto")
            var stringToBitmap: String =
                file.inputStream().readBytes().toString(Charsets.UTF_8)
            val bitmap = StringToBitMap(stringToBitmap)
            welcomText(text = stringResource(R.string.Hello) + " " + surname)
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
                            .size(100.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                }
                val intent = Intent(context, ProfilSettingsActivity::class.java)
                settingsButton(context = context, intent = intent)
            }

        }


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