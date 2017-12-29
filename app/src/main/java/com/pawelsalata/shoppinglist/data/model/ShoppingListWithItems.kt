package com.pawelsalata.shoppinglist.data.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.data.entities.ShoppingList

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ShoppingListWithItems {
    @Embedded lateinit var shoppingList: ShoppingList

    @Relation(parentColumn = "id",
            entityColumn = "shoppingListId")
    lateinit var itemsList: List<Item>

}