package com.pawelsalata.shoppinglist.ui.shopping_lists.archived

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.ui.shopping_lists.BaseShoppingListsViewModel

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ArchivedShoppingListsViewModel(application: Application) : BaseShoppingListsViewModel(application), ArchivedShoppingListsInterface.UserActions {
    override fun isAddListFABVisible(): Boolean = false

    val shoppingListsLiveData: MutableLiveData<List<ShoppingList>> = MutableLiveData()
}