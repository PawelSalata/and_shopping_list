package com.pawelsalata.shoppinglist.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pawelsalata.shoppinglist.data.dao.ShoppingListWithItemsDao
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.data.entities.ShoppingList

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Database(version = 1,
        entities = arrayOf(Item::class, ShoppingList::class))
abstract class ShoppingListsDatabase: RoomDatabase() {

    abstract fun getShoppingListWithItemsDao(): ShoppingListWithItemsDao
}