package com.pawelsalata.shoppinglist.ui.details

import android.arch.lifecycle.ViewModelProviders
import com.pawelsalata.shoppinglist.ui.main.MainActivity
import com.pawelsalata.shoppinglist.ui.main.MainViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by LETTUCE on 18.01.2018.
 */
@Module
class ShoppingListDetailsActivityModule {

    @Provides
    fun provideViewModel(activity: ShoppingListDetailsActivity) : ShoppingListDetailsViewModel {
        return ViewModelProviders.of(activity).get(ShoppingListDetailsViewModel::class.java)
    }
}