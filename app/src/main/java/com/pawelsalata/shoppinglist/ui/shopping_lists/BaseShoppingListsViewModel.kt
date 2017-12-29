package com.pawelsalata.shoppinglist.ui.shopping_lists

import android.arch.lifecycle.ViewModel

/**
 * Created by LETTUCE on 29.12.2017.
 */
abstract class BaseShoppingListsViewModel : ViewModel() {
    abstract fun isAddListFABVisible(): Boolean
}