package com.pawelsalata.shoppinglist.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.pawelsalata.shoppinglist.data.entities.Item

/**
 * Created by LETTUCE on 22.01.2018.
 */
@Dao
abstract class ItemDao {

    @Insert
    abstract fun insert(vararg entities: Item)
}