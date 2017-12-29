package com.pawelsalata.shoppinglist.ui.shopping_lists.archived

import android.arch.lifecycle.MutableLiveData
import com.pawelsalata.shoppinglist.data.model.ShoppingList
import com.pawelsalata.shoppinglist.ui.shopping_lists.BaseShoppingListsViewModel

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ArchivedShoppingListsViewModel : BaseShoppingListsViewModel(), ArchivedShoppingListsInterface.UserActions {
    override fun isAddListFABVisible(): Boolean = true

    val shoppingListsLiveData: MutableLiveData<List<ShoppingList>> = MutableLiveData()
}