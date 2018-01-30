package com.pawelsalata.shoppinglist.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update
import com.pawelsalata.shoppinglist.data.database.entities.Item

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Dao
abstract class ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: Item)

    @Update
    abstract fun update(entity: Item)
}