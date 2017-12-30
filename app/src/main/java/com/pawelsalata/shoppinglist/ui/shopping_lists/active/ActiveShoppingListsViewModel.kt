package com.pawelsalata.shoppinglist.ui.shopping_lists.active

import android.app.Application
import android.view.View
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.data.repository.ShoppingListsRepository
import com.pawelsalata.shoppinglist.ui.shopping_lists.BaseShoppingListsViewModel
import com.pawelsalata.shoppinglist.utils.extensions.logd

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ActiveShoppingListsViewModel(application: Application) : BaseShoppingListsViewModel(application), ActiveShoppingListsInterface.UserActions {

    val shoppingListsLiveData = ShoppingListsRepository.getActiveShoppingLists(application)

    override fun isAddListFABVisible(): Boolean = true

    override fun onAddListClick(v: View) {
        logd("Add list clicked")
        val shoppingListWithItems = ShoppingListWithItems()
        shoppingListWithItems.shoppingList =
                ShoppingList("New shopping list")
        shoppingListWithItems.itemsList = ArrayList()
        ShoppingListsRepository.addShoppingList(getApplication(), shoppingListWithItems)
    }
}