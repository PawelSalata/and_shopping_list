package com.pawelsalata.shoppinglist.data.database

import android.arch.lifecycle.LiveData
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import io.reactivex.Observable

/**
 * Created by LETTUCE on 22.01.2018.
 */
interface DbHelper {

    fun saveShoppingListWithItems(shoppingList: ShoppingListWithItems): Observable<Boolean>

    fun getShoppingListWithItems(listId: Int): LiveData<ShoppingListWithItems>

    fun saveShoppingList(shoppingList: ShoppingList): Observable<Boolean>

    fun getActiveLists(): LiveData<List<ShoppingList>>

    fun getArchivedLists(): LiveData<List<ShoppingList>>
}