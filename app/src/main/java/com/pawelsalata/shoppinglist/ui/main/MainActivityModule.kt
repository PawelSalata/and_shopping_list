package com.pawelsalata.shoppinglist.ui.main

import android.support.v4.app.FragmentManager
import com.pawelsalata.shoppinglist.di.scopes.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideFragmentManager(activity: MainActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}