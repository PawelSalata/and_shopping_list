package com.pawelsalata.shoppinglist.ui.shopping_lists

import android.view.View as AndroidView
import com.pawelsalata.shoppinglist.data.entities.ShoppingList

/**
 * Created by LETTUCE on 29.12.2017.
 */
interface ShoppingListsInterface {
    interface View {
        fun openShoppingList(shoppingList: ShoppingList)
    }

    interface UserActions {
        fun onShoppingListClick(v: AndroidView)
    }
}