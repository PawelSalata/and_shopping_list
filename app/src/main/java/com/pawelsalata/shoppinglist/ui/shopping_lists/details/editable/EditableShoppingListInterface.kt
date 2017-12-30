package com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable

import android.view.View

/**
 * Created by LETTUCE on 30.12.2017.
 */
interface EditableShoppingListInterface {

    interface UserActions {
        fun onAddItemClick(v: View)
        fun onSaveListClick(v: View)
    }
}