package com.pawelsalata.shoppinglist.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.pawelsalata.shoppinglist.utils.extensions.toFriendlyDate

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

    @Ignore
    fun getFriendlyDate(): String {
        return timestamp.toFriendlyDate()
    }
}