package com.pawelsalata.shoppinglist.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by LETTUCE on 30.12.2017.
 */
fun Long.toFriendlyDate(): String {
    return try {
        val sdf = SimpleDateFormat("HH:mm EEE, d MMM ", Locale.getDefault())
        val netDate = Date(this)
        sdf.format(netDate)
    } catch (ex: Exception) {
        "xx"
    }
}