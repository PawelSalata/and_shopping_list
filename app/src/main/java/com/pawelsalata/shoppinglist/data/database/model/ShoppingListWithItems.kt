package com.pawelsalata.shoppinglist.data.database.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.pawelsalata.shoppinglist.data.database.entities.Item
import com.pawelsalata.shoppinglist.data.database.entities.ShoppingList

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ShoppingListWithItems {
    @Embedded
    var shoppingList: ShoppingList = ShoppingList("")

    @Relation(parentColumn = "id",
            entityColumn = "shoppingListId",
            entity = Item::class)
    var itemsList: MutableList<Item> = ArrayList()

}