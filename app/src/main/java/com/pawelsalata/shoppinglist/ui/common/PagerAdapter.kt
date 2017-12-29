package com.pawelsalata.shoppinglist.ui.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by LETTUCE on 29.12.2017.
 */
class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var fragments: MutableList<Fragment> = mutableListOf()
    var titles: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}