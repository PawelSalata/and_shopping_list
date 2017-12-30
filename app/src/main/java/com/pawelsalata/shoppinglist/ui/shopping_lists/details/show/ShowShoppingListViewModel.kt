package com.pawelsalata.shoppinglist.ui.shopping_lists.details.show

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.data.repository.ShoppingListsRepository

/**
 * Created by LETTUCE on 30.12.2017.
 */
class ShowShoppingListViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var shoppingListLiveData: ShoppingListWithItems

    fun init(shoppingListId: Int) {
        shoppingListLiveData = ShoppingListsRepository.getShoppingList(getApplication(), shoppingListId)
    }
}