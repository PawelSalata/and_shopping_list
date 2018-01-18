package com.pawelsalata.shoppinglist.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.pawelsalata.shoppinglist.BR
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.databinding.ActivityMainBinding
import com.pawelsalata.shoppinglist.ui.base.BaseActivity
import com.pawelsalata.shoppinglist.ui.common.PagerAdapter
import com.pawelsalata.shoppinglist.ui.shopping_lists.active.ActiveShoppingListsFragment
import com.pawelsalata.shoppinglist.ui.shopping_lists.archived.ArchivedShoppingListsFragment
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainActivityNavigator {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.navigator = this
        setupViewPager()
    }

    private fun setupViewPager() {
        pagerAdapter.addFragment(ActiveShoppingListsFragment(), getString(R.string.active))
        pagerAdapter.addFragment(ArchivedShoppingListsFragment(), getString(R.string.archived))
        mViewDataBinding.viewPager.adapter = pagerAdapter
        mViewDataBinding.viewPager.offscreenPageLimit = 1
    }

    override fun getBindingVariable() = BR.viewModel

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun getLayoutId() = R.layout.activity_main
}
