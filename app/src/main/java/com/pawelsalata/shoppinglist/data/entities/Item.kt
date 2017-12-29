package com.pawelsalata.shoppinglist.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by LETTUCE on 29.12.2017.
 */
@Entity
class Item(@PrimaryKey var id: Int,
           var text: String,
           var shoppingListId: Int)