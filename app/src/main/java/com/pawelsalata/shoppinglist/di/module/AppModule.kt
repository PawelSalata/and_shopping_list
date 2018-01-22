package com.pawelsalata.shoppinglist.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pawelsalata.shoppinglist.data.AppDataManager
import com.pawelsalata.shoppinglist.data.database.AppDatabase
import com.pawelsalata.shoppinglist.data.database.AppDbHelper
import com.pawelsalata.shoppinglist.data.database.DbHelper
import com.pawelsalata.shoppinglist.di.DatabaseInfo
import com.pawelsalata.shoppinglist.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
abstract class AppModule {

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

    @Provides
    @Singleton
    abstract fun provideDbHelper(appDatabase: AppDatabase): AppDbHelper

    @Provides
    @Singleton
    abstract fun provideDataManager(dbHelper: DbHelper): AppDataManager
}