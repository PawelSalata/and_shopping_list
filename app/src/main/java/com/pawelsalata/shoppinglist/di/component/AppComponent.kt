package com.pawelsalata.shoppinglist.di.component

import android.app.Application
import com.pawelsalata.shoppinglist.di.builder.ActivityBuilder
import com.pawelsalata.shoppinglist.di.module.AppModule
import com.pawelsalata.shoppinglist.ui.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}