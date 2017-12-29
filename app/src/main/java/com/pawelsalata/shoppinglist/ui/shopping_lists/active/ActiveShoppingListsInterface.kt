package com.pawelsalata.shoppinglist.ui.shopping_lists.active

import com.pawelsalata.shoppinglist.ui.ShoppingListsInterface

/**
 * Created by LETTUCE on 29.12.2017.
 */
interface ActiveShoppingListsInterface {

    interface UserActions {
        fun onAddListClick(v: ShoppingListsInterface.View)
    }
}