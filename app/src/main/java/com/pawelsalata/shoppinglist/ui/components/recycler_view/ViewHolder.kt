package com.pawelsalata.shoppinglist.ui.components.recycler_view

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.pawelsalata.shoppinglist.BR

/**
 * Created by LETTUCE on 30.12.2017.
 */
class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(obj: Any) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }
}