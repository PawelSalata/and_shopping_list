package com.pawelsalata.shoppinglist.utils

import com.pawelsalata.shoppinglist.utils.extensions.toFriendlyDate

/**
 * Created by LETTUCE on 30.12.2017.
 */
object DateUtils {

    fun getFriendlyDate(timestamp: Long): String {
        return timestamp.toFriendlyDate()
    }
}