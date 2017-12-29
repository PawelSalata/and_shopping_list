package com.pawelsalata.shoppinglist.ui.shopping_lists

import android.view.View
import com.pawelsalata.shoppinglist.data.model.ShoppingList

/**
 * Created by LETTUCE on 29.12.2017.
 */
interface ShoppingListsInterface {
    interface View {
        fun openShoppingList(shoppingList: ShoppingList)
    }
}