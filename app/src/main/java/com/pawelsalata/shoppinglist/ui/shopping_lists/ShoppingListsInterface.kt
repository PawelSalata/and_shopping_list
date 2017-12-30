package com.pawelsalata.shoppinglist.ui.shopping_lists

import android.support.v4.util.Pair
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import android.view.View as AndroidView

/**
 * Created by LETTUCE on 29.12.2017.
 */
interface ShoppingListsInterface {
    interface View {
        fun openShoppingList(shoppingList: ShoppingList)
    }

    interface UserActions {
        fun onShoppingListClick(shoppingListWithItems: ShoppingListWithItems, transition: Pair<AndroidView, String>)
    }
}