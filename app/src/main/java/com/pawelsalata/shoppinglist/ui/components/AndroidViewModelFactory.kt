package com.pawelsalata.shoppinglist.ui.components

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by LETTUCE on 29.12.2017.
 */
class AndroidViewModelFactory(private val application: Application?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(application!!)
    }
}