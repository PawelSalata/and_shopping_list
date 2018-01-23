package com.pawelsalata.shoppinglist.ui.details

import android.arch.lifecycle.LiveData
import android.databinding.Bindable
import android.databinding.Observable
import com.pawelsalata.shoppinglist.data.DataManager
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by LETTUCE on 18.01.2018.
 */
class ShoppingListDetailsViewModel @Inject constructor(dataManager: DataManager) :
        BaseViewModel<ShoppingListDetailsNavigator>(dataManager), Observable {

    lateinit var shoppingListLiveData: LiveData<ShoppingListWithItems>

    fun init(shoppingListId: Int) {
        shoppingListLiveData = dataManager.getShoppingListWithItems(shoppingListId)
    }

    @Bindable
    fun isListActive(): Boolean = shoppingListLiveData.value?.shoppingList?.archived?.not() != false

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}