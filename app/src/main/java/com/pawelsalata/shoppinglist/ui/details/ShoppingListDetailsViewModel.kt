package com.pawelsalata.shoppinglist.ui.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.Bindable
import android.databinding.Observable
import com.pawelsalata.shoppinglist.data.DataManager
import com.pawelsalata.shoppinglist.data.database.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by LETTUCE on 18.01.2018.
 */
class ShoppingListDetailsViewModel @Inject constructor(dataManager: DataManager) :
        BaseViewModel<ShoppingListDetailsNavigator>(dataManager), Observable {

    var shoppingListLiveData: LiveData<ShoppingListWithItems> = MutableLiveData()

    fun init(shoppingListId: Int) {
        shoppingListLiveData = dataManager.getShoppingListWithItems(shoppingListId)
    }

    @Bindable
    fun isListActive(): Boolean = shoppingListLiveData.value?.shoppingList?.archived?.not() == true

    fun saveList() {
        if (isListActive()) {
            shoppingListLiveData.value?.let {
                dataManager.saveShoppingListWithItems(it)
                        .subscribeOn(Schedulers.io())
                        .subscribe()
            }
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}