package com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.data.repository.ShoppingListsRepository

/**
 * Created by LETTUCE on 30.12.2017.
 */
class EditableShoppingListViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var shoppingListLiveData: ShoppingListWithItems

    fun init(shoppingListId: Int) {
        shoppingListLiveData = ShoppingListsRepository.getShoppingList(getApplication(), shoppingListId)
    }

    fun createItem(): Item {
        return Item("", shoppingListLiveData.shoppingList.id)
    }

    fun saveShoppingList() {
        ShoppingListsRepository.updateShoppingListWithItems(getApplication(), shoppingListLiveData)
    }

//    override fun onAddItemClick(v: View) {
//        shoppingListLiveData.value?.let {
//             it.itemsList.add(Item("", it.shoppingList.id))
//        }
//    }
}