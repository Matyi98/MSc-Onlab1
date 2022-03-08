package hu.matyi.familyorganiser.components

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
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

@Composable
fun basicButton(context: Context, text: String, intent: Intent) {
    Button(
        onClick = {
            context.startActivity(intent)
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