package hu.matyi.familyorganiser.views.shoppingList.fragment
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import java.io.*
import java.lang.Exception
import android.content.Context.MODE_PRIVATE
import android.content.Intent

import android.content.SharedPreferences
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.pager.*
import hu.matyi.familyorganiser.components.settingsButton
import hu.matyi.familyorganiser.views.profilSettings.ProfilSettings

@Composable
fun ShoppingTab()
{
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ShoppingScreen()
    }
}

//https://developer.android.com/codelabs/jetpack-compose-state?hl=ja#5
@Composable
fun ShoppingListItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

data class ShoppingItem(val id: Int, val label: String)
private fun getShoppingItem() = List(10) { i -> ShoppingItem(i, "Food # $i") }

@Composable
fun ShoppingList(
    modifier: Modifier = Modifier,
    list: List<ShoppingItem> = remember { getShoppingItem() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            ShoppingListItem(taskName = "demoTask0",false,{},{})
        }
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            //Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter() {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count, { count++ })
}

@Composable
fun ShoppingScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter()
        ShoppingList()
    }
}