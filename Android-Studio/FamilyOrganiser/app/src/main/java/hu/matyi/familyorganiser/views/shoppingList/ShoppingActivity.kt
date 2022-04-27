package hu.matyi.familyorganiser.views.shoppingList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import hu.matyi.familyorganiser.ui.theme.FamilyOrganiserTheme
import hu.matyi.familyorganiser.views.shoppingList.fragment.ShoppingTab


class ShoppingListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyOrganiserTheme {
                Screen()
            }
        }
    }
}

@Composable
private fun Screen() {
    ShoppingTab()    
}