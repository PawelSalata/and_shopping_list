package com.pawelsalata.shoppinglist.di.builder

import com.pawelsalata.shoppinglist.di.scopes.PerActivity
import com.pawelsalata.shoppinglist.ui.details.ShoppingListDetailsActivity
import com.pawelsalata.shoppinglist.ui.details.ShoppingListDetailsActivityModule
import com.pawelsalata.shoppinglist.ui.list.ShoppingListsFragmentProvider
import com.pawelsalata.shoppinglist.ui.main.MainActivity
import com.pawelsalata.shoppinglist.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class,
            ShoppingListsFragmentProvider::class))
    @PerActivity
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(ShoppingListDetailsActivityModule::class))
    @PerActivity
    abstract fun bindShoppingListDetailsActivity(): ShoppingListDetailsActivity
}