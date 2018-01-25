package com.pawelsalata.shoppinglist.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.pawelsalata.shoppinglist.data.dao.ShoppingListWithItemsDaoClass
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems

/**
 * Created by LETTUCE on 29.12.2017.
 */
object ShoppingListsRepository {

    fun getActiveShoppingLists(context: Context): LiveData<List<ShoppingListWithItems>> {
        return getShoppingListDao(context)
                .getActiveShoppingListsWithItems()
    }

    fun getArchivedShoppingLists(context: Context): LiveData<List<ShoppingListWithItems>> {
        return getShoppingListDao(context)
                .getArchivedShoppingListsWithItems()
    }

    fun addShoppingList(context: Context, shoppingList: ShoppingListWithItems) {
        getShoppingListDao(context)
                .insertShoppingListWithItems(shoppingList)
    }

    fun archiveShoppingList(context: Context, shoppingListWithItems: ShoppingListWithItems) {
        shoppingListWithItems.shoppingList.archived = true
        getShoppingListDao(context)._update(shoppingListWithItems.shoppingList)
    }

    private fun getShoppingListDao(context: Context): ShoppingListWithItemsDaoClass {
        return object : ShoppingListWithItemsDaoClass() {
            override fun _insert(shoppingList: ShoppingList) {

            }

            override fun _insertAll(items: List<Item>) {

            }

            override fun _update(shoppingList: ShoppingList) {

            }

            override fun _updateAll(items: List<Item>) {

            }

            override fun getAllShoppingListsWithItems(): LiveData<List<ShoppingListWithItems>> {
                return MutableLiveData()
            }

            override fun getActiveShoppingListsWithItems(): LiveData<List<ShoppingListWithItems>> {
                return MutableLiveData()
            }

            override fun getArchivedShoppingListsWithItems(): LiveData<List<ShoppingListWithItems>> {
                return MutableLiveData()
            }

            override fun getShoppingList(id: Int): ShoppingListWithItems {
                return ShoppingListWithItems()
            }
        }
    }

    fun getShoppingList(context: Context, shoppingListId: Int): ShoppingListWithItems {
        return getShoppingListDao(context).getShoppingList(shoppingListId)
    }

    fun updateShoppingListWithItems(context: Context, shoppingListWithItems: ShoppingListWithItems) {
        getShoppingListDao(context)
                .updateShoppingListWithItems(shoppingListWithItems)
    }

}