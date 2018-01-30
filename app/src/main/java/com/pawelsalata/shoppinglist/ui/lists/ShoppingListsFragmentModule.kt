package com.pawelsalata.shoppinglist.ui.lists

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.pawelsalata.shoppinglist.di.qualifiers.InstanceContext
import com.pawelsalata.shoppinglist.di.scopes.PerFragment
import dagger.Module
import dagger.Provides

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Module
class ShoppingListsFragmentModule {

    @Provides
    @PerFragment
    @InstanceContext
    fun provideContext(fragment: ShoppingListsFragment): Context = fragment.context

    @Provides
    @PerFragment
    fun provideLayoutManager(@InstanceContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    @Provides
    @PerFragment
    fun provideAdapter(): ShoppingListsAdapter = ShoppingListsAdapter()
}