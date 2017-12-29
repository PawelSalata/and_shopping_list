package com.pawelsalata.shoppinglist.ui.shopping_lists.active

import android.arch.lifecycle.ViewModel
import com.pawelsalata.shoppinglist.ui.ShoppingListsInterface
import com.pawelsalata.shoppinglist.ui.shopping_lists.ShoppingListsViewModel

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ActiveShoppingListViewModel : ShoppingListsViewModel(), ActiveShoppingListsInterface.UserActions {
    override fun isAddListFABVisible(): Boolean = true

    override fun onAddListClick(v: ShoppingListsInterface.View) {

    }
}