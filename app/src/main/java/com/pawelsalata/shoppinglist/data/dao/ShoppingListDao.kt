package com.pawelsalata.shoppinglist.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.pawelsalata.shoppinglist.data.entities.ShoppingList

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Dao
abstract class ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: ShoppingList)

    @Update
    abstract fun update(entity: ShoppingList)

    @Transaction
    @Query("SELECT * FROM shopping_lists WHERE archived = :archived ORDER BY timestamp DESC")
    abstract fun getShoppingLists(archived: Int): LiveData<List<ShoppingList>>
}