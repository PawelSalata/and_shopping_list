package com.pawelsalata.shoppinglist.ui.details

import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.data.repository.ShoppingListsRepository
import com.pawelsalata.shoppinglist.ui.base.BaseViewModel

/**
 * Created by LETTUCE on 18.01.2018.
 */
class ShoppingListDetailsViewModel: BaseViewModel<ShoppingListDetailsNavigator>() {

    lateinit var shoppingListLiveData: ShoppingListWithItems

    fun init(shoppingListId: Int) {
        shoppingListLiveData = ShoppingListsRepository.getShoppingList(getApplication(), shoppingListId)
    }



}