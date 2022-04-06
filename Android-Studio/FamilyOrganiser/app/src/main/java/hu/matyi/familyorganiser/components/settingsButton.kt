package hu.matyi.familyorganiser.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R

@Composable
public fun settingsButton(context: Context, intent: Intent, check: () -> Boolean = {true}) {
    IconButton(
        onClick = {
            if(check()) {
                context.startActivity(intent)
                (context as Activity).overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
            }
            else
            {
                Toast.makeText(context, "Something went wrong.", Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        enabled = true,

    )
    {
        Icon(
            Icons.Filled.Settings,
            contentDescription = "Localized description",
            tint = Color.White
        )
    }
}