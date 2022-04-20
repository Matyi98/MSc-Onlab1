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
    val pagerState = rememberPagerState()

    val pages = listOf(0,1,2)
    Column() {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = getTitleFromIndex(index)) },
                    selected = pagerState.currentPage == index,
                    onClick = { /* TODO */ },
                )
            }
        }
        HorizontalPager(
            3,
            state = pagerState
        ) { page ->
            when (page) {
                0 -> helloCard(context = context, surname = surname)
                1 -> memberListCard(
                    surname = surname,
                    lastname = lastname,
                    birthday = birthday,
                    email = email
                )
                2 -> ShoppingTab()
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
                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
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
                    val intent = Intent(context, ProfilSettings::class.java)
                    settingsButton(context = context, intent = intent)
                }

            }


        }
    }



@Composable
fun memberListTitle() {
    Text(
        text = stringResource(R.string.Members),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
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

fun getTitleFromIndex(Index : Int) : String
{
    var title : String = "empty"
    when(Index)
    {
        0 -> title = "Menu"
        1-> title = "Members"
        2-> title = "Shopping"
    }
    return title
}

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
