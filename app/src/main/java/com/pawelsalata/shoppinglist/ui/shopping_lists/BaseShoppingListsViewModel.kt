package com.pawelsalata.shoppinglist.ui.shopping_lists

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel

/**
 * Created by LETTUCE on 29.12.2017.
 */
abstract class BaseShoppingListsViewModel(application: Application) : AndroidViewModel(application) {
    abstract fun isAddListFABVisible(): Boolean
}