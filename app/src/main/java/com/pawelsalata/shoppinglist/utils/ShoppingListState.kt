package com.pawelsalata.shoppinglist.utils

/**
 * Created by LETTUCE on 23.01.2018.
 */
enum class ShoppingListState(val archived: Boolean) {
    ACTIVE(false),
    ARCHIVED(true);

    fun getValue(): Boolean {
        return archived
    }
}