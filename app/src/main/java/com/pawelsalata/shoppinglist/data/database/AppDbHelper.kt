package com.pawelsalata.shoppinglist.data.database

import android.arch.lifecycle.LiveData
import com.pawelsalata.shoppinglist.data.database.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.database.model.ShoppingListWithItems
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Singleton
class AppDbHelper @Inject constructor(val appDatabase: AppDatabase) : DbHelper {
    override fun saveShoppingListWithItems(shoppingList: ShoppingListWithItems): Observable<Boolean> {
        return Observable.fromCallable {
            shoppingList.itemsList.forEach { it.shoppingListId = shoppingList.shoppingList.id }
            appDatabase.getItemDao().insert(*shoppingList.itemsList.toTypedArray())
            appDatabase.getShoppingListDao().insert(shoppingList.shoppingList)
            return@fromCallable true
        }
    }

    override fun getShoppingListWithItems(listId: Int): LiveData<ShoppingListWithItems> {
        return appDatabase.getShoppingListWithItemsDao().getShoppingList(listId)
    }

    override fun saveShoppingList(shoppingList: ShoppingList): Observable<Boolean> {
        return Observable.fromCallable {
            appDatabase.getShoppingListDao().insert(shoppingList)
            return@fromCallable true
        }
    }

    override fun archiveList(shoppingList: ShoppingList): Observable<Boolean> {
        return Observable.fromCallable {
            shoppingList.archived = true
            appDatabase.getShoppingListDao().update(shoppingList)
            return@fromCallable true
        }
    }

    override fun getActiveLists(): LiveData<List<ShoppingList>> {
        return appDatabase.getShoppingListDao().getShoppingLists(0)
    }

    override fun getArchivedLists(): LiveData<List<ShoppingList>> {
        return appDatabase.getShoppingListDao().getShoppingLists(1)
    }


}