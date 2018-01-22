package com.pawelsalata.shoppinglist.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Dao
abstract class ShoppingListDao {

    @Insert
    abstract fun insert(vararg entities: ShoppingList)

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE archived = :archived ORDER BY timestamp DESC")
    abstract fun getShoppingLists(archived: Int): LiveData<List<ShoppingList>>
}