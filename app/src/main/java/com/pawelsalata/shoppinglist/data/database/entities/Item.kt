package com.pawelsalata.shoppinglist.data.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Entity
class Item(var text: String,
           var shoppingListId: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
