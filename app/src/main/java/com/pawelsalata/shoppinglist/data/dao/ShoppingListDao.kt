package com.pawelsalata.shoppinglist.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems

/**
 * Created by LETTUCE on 22.01.2018.
 */
interface ShoppingListDao: BaseDao<ShoppingList> {

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE archived = :archived ORDER BY timestamp DESC")
    abstract fun getShoppingLists(archived: Int): LiveData<List<ShoppingList>>
}