package com.pawelsalata.shoppinglist.data.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.pawelsalata.shoppinglist.data.database.model.ShoppingListWithItems

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Dao
abstract class ShoppingListWithItemsDao {

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE id = :id")
    abstract fun getShoppingList(id: Int): LiveData<ShoppingListWithItems>

}