package com.pawelsalata.shoppinglist.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pawelsalata.shoppinglist.data.database.dao.ItemDao
import com.pawelsalata.shoppinglist.data.database.dao.ShoppingListDao
import com.pawelsalata.shoppinglist.data.database.dao.ShoppingListWithItemsDao
import com.pawelsalata.shoppinglist.data.database.entities.Item
import com.pawelsalata.shoppinglist.data.database.entities.ShoppingList


/**
 * Created by LETTUCE on 29.12.2017.
 */
@Database(
        version = 1,
        entities = arrayOf(Item::class, ShoppingList::class))
abstract class AppDatabase : RoomDatabase() {

    abstract fun getShoppingListDao(): ShoppingListDao
    abstract fun getItemDao(): ItemDao
    abstract fun getShoppingListWithItemsDao(): ShoppingListWithItemsDao
}