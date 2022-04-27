package hu.matyi.familyorganiser.views.familyMainView.fragments

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R
import hu.matyi.familyorganiser.components.basicButton
import hu.matyi.familyorganiser.components.welcomText
import hu.matyi.familyorganiser.views.shoppingList.ShoppingListActivity


@Composable
fun ShoppingCollections()
 {
    val context = LocalContext.current

    var button by remember { mutableStateOf(1) }
    /**/Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { button++ },
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                backgroundColor = Color(R.color.teal_700)
            ) {
                Icon(Icons.Default.Add, contentDescription = "content description")
            }
        }
    )
    {
        /**/  Card(
        Modifier.Companion
            .padding(8.dp),
        shape = RoundedCornerShape(32.dp)

        )
        {
            Column(
                modifier = Modifier
                    .background(color = Color(R.color.teal_700))
                    .fillMaxWidth()
                    .fillMaxSize()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            )
            {
                welcomText(text = "Here are your shopping lists: ")
                repeat(button) {
                    val intent = Intent(context, ShoppingListActivity::class.java)
                    basicButton(context = context, text = "Shopping list", intent)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

}