package com.pawelsalata.shoppinglist.ui

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * Created by LETTUCE on 30.12.2017.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        installLeakCanary()
    }

    private fun installLeakCanary() {
        LeakCanary.install(this)
    }

}