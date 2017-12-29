package com.pawelsalata.shoppinglist.data.dao

import android.arch.persistence.room.*
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Dao
interface ShoppingListWithItemsDao {

    @Insert
    fun insert(shoppingListWithItems: ShoppingListWithItems)

    @Update
    fun update(vararg shoppingListsWithItems: ShoppingListWithItems)

    @Delete
    fun delete(vararg shoppingListsWithItems: ShoppingListWithItems)

    @Query("SELECT * FROM shopping_list")
    fun getShoppingListWithItems(): List<ShoppingListWithItems>
}