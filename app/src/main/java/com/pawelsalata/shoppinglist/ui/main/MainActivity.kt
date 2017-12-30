package com.pawelsalata.shoppinglist.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.databinding.ActivityMainBinding
import com.pawelsalata.shoppinglist.ui.common.PagerAdapter
import com.pawelsalata.shoppinglist.ui.shopping_lists.active.ActiveShoppingListsFragment
import com.pawelsalata.shoppinglist.ui.shopping_lists.archived.ArchivedShoppingListsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .also { viewBinding = it!! }
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
                .also { viewModel = it }
        viewBinding.viewModel = viewModel
        viewBinding.pagerAdapter = createPagerAdapter()

        setupViewPager()
    }

    private fun createPagerAdapter(): PagerAdapter {
        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(ActiveShoppingListsFragment(), getString(R.string.active))
        adapter.addFragment(ArchivedShoppingListsFragment(), getString(R.string.archived))
        return adapter
    }

    private fun setupViewPager() {
        viewPager.offscreenPageLimit = 1
    }

}
