package hu.matyi.familyorganiser.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R


@Composable
fun basicButton(context: Context, text: String, intent: Intent? = null, check: () -> Boolean = {true}, extraFunction: () -> Unit = {}) {
    extraFunction()
    Button(
        onClick = {
            if(check() && intent != null) {
                context.startActivity(intent)
                (context as Activity).overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
            }
            else if (intent != null)
            {
                Toast.makeText(context, "Something went wrong.", Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        enabled = true,
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
        shape = MaterialTheme.shapes.medium,
    )
    {
        Text(text = text, color = Color.White)
    }
}