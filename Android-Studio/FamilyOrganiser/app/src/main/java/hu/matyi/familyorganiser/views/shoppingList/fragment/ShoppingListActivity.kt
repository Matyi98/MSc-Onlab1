package hu.matyi.familyorganiser.views.shoppingList.fragment
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

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