package hu.matyi.familyorganiser.views.familyMainView

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
import hu.matyi.familyorganiser.views.familyMainView.fragments.*


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
                2 -> ShoppingCollections()
            }
        }
    }
    BackHandler {
        (context as Activity).finish()
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

