package hu.matyi.familyorganiser.components

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hu.matyi.familyorganiser.R

@Composable
fun secondOptionButton(context: Context, text: String, intent: Intent) {
    Button(
        onClick = {
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(R.color.teal_700)),
    )
    {
        Text(text = text, color = Color.White)
    }
}