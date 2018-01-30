package com.pawelsalata.shoppinglist.ui.lists

import com.pawelsalata.shoppinglist.di.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by LETTUCE on 23.01.2018.
 */
@Module
abstract class ShoppingListsFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(ShoppingListsFragmentModule::class))
    @PerFragment
    abstract fun provideShoppingListsFragment(): ShoppingListsFragment
}