package com.pawelsalata.shoppinglist.di.builder

import com.pawelsalata.shoppinglist.ui.main.MainActivity
import com.pawelsalata.shoppinglist.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}