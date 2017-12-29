package com.pawelsalata.shoppinglist.ui.shopping_lists.active

import android.view.View
import com.pawelsalata.shoppinglist.ui.shopping_lists.BaseShoppingListsViewModel
import com.pawelsalata.shoppinglist.utils.extensions.logd

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ActiveShoppingListsViewModel : BaseShoppingListsViewModel(), ActiveShoppingListsInterface.UserActions {
    override fun isAddListFABVisible(): Boolean = true

    override fun onAddListClick(v: View) {
        logd("Add list clicked")
    }
}