package hu.matyi.familyorganiser.views.familyMainView.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.matyi.familyorganiser.R

@Composable
fun memberListCard(
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
        Column(Modifier.background(color = Color(R.color.teal_700))
            .fillMaxWidth()
            .fillMaxHeight())

        {
            memberListTitle()
            /*Card(
                Modifier
                    .weight(1f)
                    .padding(10.dp)
                    .padding(8.dp)
            )
            {*/
                Column(Modifier.fillMaxSize().background(color = Color(R.color.teal_700)),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    surname?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                    lastname?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                    birthday?.let { it1 -> TextField(value = it1, onValueChange = {}) }
                    email?.let { it1 -> TextField(value = it1, onValueChange = {}) }
               // }
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

