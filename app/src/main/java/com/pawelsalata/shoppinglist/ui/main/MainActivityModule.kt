package com.pawelsalata.shoppinglist.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.FragmentManager
import com.pawelsalata.shoppinglist.ui.common.PagerAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(activity: MainActivity) : MainViewModel {
        return ViewModelProviders.of(activity).get(MainViewModel::class.java)
    }

    @Provides
    fun provideFragmentManager(activity: MainActivity): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    fun providePagerAdapter(fragmentManager: FragmentManager): PagerAdapter {
        return PagerAdapter(fragmentManager)
    }
}