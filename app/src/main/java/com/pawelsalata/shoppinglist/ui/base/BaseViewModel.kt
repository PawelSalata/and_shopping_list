package com.pawelsalata.shoppinglist.ui.base

import android.arch.lifecycle.ViewModel
import com.pawelsalata.shoppinglist.data.DataManager
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by LETTUCE on 17.01.2018.
 */
abstract class BaseViewModel<N>(protected val dataManager: DataManager) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    var navigator: N? = null

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}