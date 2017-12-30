package com.pawelsalata.shoppinglist.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Dao
abstract class ShoppingListWithItemsDao {

    fun insertShoppingListWithItems(shoppingListWithItems: ShoppingListWithItems) {
        shoppingListWithItems.itemsList.forEach {
            it.shoppingListId = shoppingListWithItems.shoppingList.id
        }
        _insert(shoppingListWithItems.shoppingList)
        _insertAll(shoppingListWithItems.itemsList)
    }

    fun updateShoppingListWithItems(shoppingListWithItems: ShoppingListWithItems) {
        shoppingListWithItems.itemsList.forEach {
            it.shoppingListId = shoppingListWithItems.shoppingList.id
        }
        _update(shoppingListWithItems.shoppingList)
        _updateAll(shoppingListWithItems.itemsList)
    }

    @Insert
    internal abstract fun _insert(shoppingList: ShoppingList)

    @Insert
    internal abstract fun _insertAll(items: List<Item>)

    @Update
    internal abstract fun _update(shoppingList: ShoppingList)

    @Update
    internal abstract fun _updateAll(items: List<Item>)



//    @Update
//    abstract fun _update(vararg shoppingListsWithItems: ShoppingListWithItems)
//
//    @Delete
//    abstract fun _delete(vararg shoppingListsWithItems: ShoppingListWithItems)

    @Transaction
    @Query("SELECT * FROM shopping_lists")
    abstract fun getAllShoppingListsWithItems(): LiveData<List<ShoppingListWithItems>>

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE archived = 0 ORDER BY timestamp DESC")
    abstract fun getActiveShoppingListsWithItems(): LiveData<List<ShoppingListWithItems>>

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE archived = 1 ORDER BY timestamp DESC")
    abstract fun getArchivedShoppingListsWithItems(): LiveData<List<ShoppingListWithItems>>

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE id = :id")
    abstract fun getShoppingList(id: Int): ShoppingListWithItems
}