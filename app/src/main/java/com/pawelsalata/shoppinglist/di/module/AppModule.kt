package com.pawelsalata.shoppinglist.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pawelsalata.shoppinglist.data.database.AppDatabase
import com.pawelsalata.shoppinglist.di.DatabaseInfo
import com.pawelsalata.shoppinglist.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = AppConstants.DB_NAME

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }
}