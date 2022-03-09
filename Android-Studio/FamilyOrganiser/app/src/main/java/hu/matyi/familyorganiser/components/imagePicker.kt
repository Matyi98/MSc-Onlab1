package hu.matyi.familyorganiser.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.OutputStreamWriter


//https://ngengesenior.medium.com/pick-image-from-gallery-in-jetpack-compose-5fa0d0a8ddaf
@Composable
fun imagePicker() : Bitmap? {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
    Column {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = stringResource(R.string.pick_image))
        }

        Spacer(modifier = Modifier.height(12.dp))
        Column(
            Modifier
                .background(Color(R.color.teal_700))
                .width(400.dp)
                .height(200.dp)
                .padding(32.dp)
        ) {
            imageUri?.let {
                if (Build.VERSION.SDK_INT < 28) {
                    bitmap.value = MediaStore.Images
                        .Media.getBitmap(context.contentResolver, it)
                } else {
                    val source = ImageDecoder
                        .createSource(context.contentResolver, it)
                    bitmap.value = ImageDecoder.decodeBitmap(source)
                }

                bitmap.value?.let { btm ->
                    Image(
                        bitmap = btm.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                }
            }
        }
    if (bitmap.value != null){
        var file = File(context.filesDir,"familyPhoto")
        file.writeText(bitmap.value!!.toBase64String())
    }
        return bitmap.value
    }


//www.android--code.com/2020/06/android-kotlin-bitmap-to-base64-string.html
fun Bitmap.toBase64String():String {
    ByteArrayOutputStream().apply {
        compress(Bitmap.CompressFormat.JPEG, 10, this)
        return Base64.encodeToString(toByteArray(), Base64.DEFAULT)
    }
}

private fun writeToFile(data: String, context: Context, fileName: String) {
    try {
        val outputStreamWriter =
            OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE))
        outputStreamWriter.write(data)
        outputStreamWriter.close()
    } catch (e: IOException) {
        Log.e("Exception", "File write failed: " + e.toString())
    }
}
