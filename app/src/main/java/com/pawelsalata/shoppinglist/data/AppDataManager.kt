package com.pawelsalata.shoppinglist.data

import android.arch.lifecycle.LiveData
import com.pawelsalata.shoppinglist.data.database.DbHelper
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Data Manager used as a single source of truth
 * In future this will also contain other helpers. For example apiHelper and/or prefsHelper
 *
 * Created by LETTUCE on 22.01.2018.
 */
@Singleton
class AppDataManager @Inject constructor(val dbHelper: DbHelper) : DataManager {

    override fun saveShoppingListWithItems(shoppingList: ShoppingListWithItems): Observable<Boolean> {
        return dbHelper.saveShoppingListWithItems(shoppingList)
    }

    override fun getShoppingListWithItems(listId: Int): LiveData<ShoppingListWithItems> {
        return dbHelper.getShoppingListWithItems(listId)
    }

    override fun saveShoppingList(shoppingList: ShoppingList): Observable<Boolean> {
        return dbHelper.saveShoppingList(shoppingList)
    }

    override fun archiveList(shoppingList: ShoppingList): Observable<Boolean> {
        return dbHelper.archiveList(shoppingList)
    }

    override fun getActiveLists(): LiveData<List<ShoppingList>> {
        return dbHelper.getActiveLists()
    }

    override fun getArchivedLists(): LiveData<List<ShoppingList>> {
        return dbHelper.getArchivedLists()
    }
}