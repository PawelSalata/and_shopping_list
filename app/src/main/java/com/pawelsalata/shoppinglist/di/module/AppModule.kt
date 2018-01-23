package com.pawelsalata.shoppinglist.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.res.Resources
import com.pawelsalata.shoppinglist.data.AppDataManager
import com.pawelsalata.shoppinglist.data.DataManager
import com.pawelsalata.shoppinglist.data.database.AppDatabase
import com.pawelsalata.shoppinglist.data.database.AppDbHelper
import com.pawelsalata.shoppinglist.data.database.DbHelper
import com.pawelsalata.shoppinglist.di.qualifiers.ApplicationContext
import com.pawelsalata.shoppinglist.di.qualifiers.DatabaseInfo
import com.pawelsalata.shoppinglist.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by LETTUCE on 17.01.2018.
 */
@Module
(includes = arrayOf(AndroidInjectionModule::class, AndroidSupportInjectionModule::class))
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = AppConstants.DB_NAME

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context, @DatabaseInfo dbName: String): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDatabase: AppDatabase): DbHelper = AppDbHelper(appDatabase)

    @Provides
    @Singleton
    fun provideDataManager(dbHelper: DbHelper): DataManager = AppDataManager(dbHelper)
}