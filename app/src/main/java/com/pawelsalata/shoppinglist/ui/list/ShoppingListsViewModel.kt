package com.pawelsalata.shoppinglist.ui.list

import android.arch.lifecycle.LiveData
import android.databinding.Observable
import android.support.v4.util.Pair
import android.view.View
import com.pawelsalata.shoppinglist.data.DataManager
import com.pawelsalata.shoppinglist.data.database.entities.ShoppingList
import com.pawelsalata.shoppinglist.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by LETTUCE on 22.01.2018.
 */
class ShoppingListsViewModel @Inject constructor(dataManager: DataManager):
        BaseViewModel<ShoppingListsNavigator>(dataManager), ShoppingListsAdapter.UserActions, Observable {

    lateinit var shoppingListsLiveData: LiveData<List<ShoppingList>>
    var archived: Boolean = false

    fun init(archived: Boolean) {
        this.archived = archived
        shoppingListsLiveData = if (archived) dataManager.getArchivedLists() else dataManager.getActiveLists()
    }

    fun onAddListClick() {
        if (areListsActive()) {
            dataManager.saveShoppingList(ShoppingList(""))
                    .subscribeOn(Schedulers.io())
                    .subscribe()
        }
    }

    override fun onShoppingListClick(shoppingList: ShoppingList, transition: Pair<View, String>) {
        navigator?.openShoppingListDetails(shoppingList, transition)
    }

    override fun onArchiveListClick(shoppingList: ShoppingList) {
        dataManager.archiveList(shoppingList)
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun areListsActive(): Boolean {
        return archived.not()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}