package com.pawelsalata.shoppinglist.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.pawelsalata.shoppinglist.data.dao.ShoppingListWithItemsDao
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.data.entities.ShoppingList


/**
 * Created by LETTUCE on 29.12.2017.
 */
@Database(
        version = 1,
        entities = arrayOf(Item::class, ShoppingList::class))
abstract class AppDatabase : RoomDatabase() {

    abstract fun getShoppingListWithItemsDao(): ShoppingListWithItemsDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase::class.java, "shopping_list-database")
                        // allow queries on the main thread.
                        // Don't do this on a real app! See PersistenceBasicSample for an example.
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}