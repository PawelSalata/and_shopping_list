package com.pawelsalata.shoppinglist.utils.extensions

import android.util.Log
import android.view.View

/**
 * Created by LETTUCE on 29.12.2017.
 */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Any.logd(message: String?) {
    Log.d(javaClass.simpleName, "" + message)
}