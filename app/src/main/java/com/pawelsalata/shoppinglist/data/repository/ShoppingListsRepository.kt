package com.pawelsalata.shoppinglist.data.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import com.pawelsalata.shoppinglist.data.dao.ShoppingListWithItemsDao
import com.pawelsalata.shoppinglist.data.database.AppDatabase
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

    private fun getShoppingListDao(context: Context): ShoppingListWithItemsDao {
        return AppDatabase.getAppDatabase(context)
                .getShoppingListWithItemsDao()
    }

    fun getShoppingList(context: Context, shoppingListId: Int): ShoppingListWithItems {
        return getShoppingListDao(context).getShoppingList(shoppingListId)
    }

    fun updateShoppingListWithItems(context: Context, shoppingListWithItems: ShoppingListWithItems) {
        getShoppingListDao(context)
                .updateShoppingListWithItems(shoppingListWithItems)
    }

}