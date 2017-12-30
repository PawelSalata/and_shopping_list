package com.pawelsalata.shoppinglist.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Entity(tableName = "shopping_lists",
        indices = arrayOf(Index("archived"), Index("timestamp")))
class ShoppingList(var name: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var archived: Boolean = false
    var timestamp: Long = System.currentTimeMillis()
}