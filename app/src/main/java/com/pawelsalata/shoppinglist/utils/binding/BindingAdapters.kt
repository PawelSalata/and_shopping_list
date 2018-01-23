package com.pawelsalata.shoppinglist.utils.binding

import android.databinding.BindingAdapter
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import com.pawelsalata.shoppinglist.ui.common.PagerAdapter
import com.pawelsalata.shoppinglist.utils.extensions.gone
import com.pawelsalata.shoppinglist.utils.extensions.visible

/**
 * Created by LETTUCE on 29.12.2017.
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:adapter")
    fun setViewPagerAdapter(viewPager: ViewPager, adapter: PagerAdapter) {
        viewPager.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("bind:viewPager")
    fun setupWithViewPager(tabLayout: TabLayout, viewPager: ViewPager) {
        tabLayout.setupWithViewPager(viewPager)
    }

    @JvmStatic
    @BindingAdapter("bind:onClick")
    fun setOnClick(view: View, listener: View.OnClickListener) {
        view.setOnClickListener(listener)
    }

    @JvmStatic
    @BindingAdapter("bind:visibility")
    fun setVisibility(view: View, visible: Boolean) {
        if (visible)
            view.visible()
        else
            view.gone()
    }
}