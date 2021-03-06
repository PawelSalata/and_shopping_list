package com.pawelsalata.shoppinglist.ui.lists

import android.support.v4.util.Pair
import android.view.View
import com.pawelsalata.shoppinglist.data.database.entities.ShoppingList

/**
 * Created by LETTUCE on 22.01.2018.
 */
interface ShoppingListsNavigator {

    fun openShoppingListDetails(shoppingList: ShoppingList, transition: Pair<View, String>)
}