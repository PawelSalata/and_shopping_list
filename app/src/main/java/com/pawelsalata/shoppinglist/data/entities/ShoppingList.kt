package com.pawelsalata.shoppinglist.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Entity(tableName = "shopping_list",
        indices = arrayOf(Index("archived"), Index("timestamp")))
class ShoppingList(@PrimaryKey var id: Int,
                   var archived: Boolean,
                   var timestamp: Long,
                   var name: String)