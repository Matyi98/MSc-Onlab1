package hu.matyi.familyorganiser.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Redo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*



@Composable
 fun randomTextInputField(text: String) : String {
    var code : String by rememberSaveable { mutableStateOf("") }
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



