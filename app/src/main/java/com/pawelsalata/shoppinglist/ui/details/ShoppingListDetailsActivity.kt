package com.pawelsalata.shoppinglist.ui.details

import android.os.Bundle
import com.pawelsalata.shoppinglist.BR
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.databinding.ActivityShoppingListDetailsBinding
import com.pawelsalata.shoppinglist.ui.base.BaseActivity
import com.pawelsalata.shoppinglist.ui.shopping_lists.details.show.ShowShoppingListActivity
import javax.inject.Inject

/**
 * Created by LETTUCE on 18.01.2018.
 */
class ShoppingListDetailsActivity : BaseActivity<ActivityShoppingListDetailsBinding, ShoppingListDetailsViewModel>(), ShoppingListDetailsNavigator {

    @Inject
    lateinit var detailsViewModel: ShoppingListDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel.navigator = this
    }

    private fun setup() {
        detailsViewModel.init(intent.getIntExtra(ShowShoppingListActivity.EXTRA_SHOPPING_LIST_ID, -1))
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): ShoppingListDetailsViewModel = detailsViewModel

    override fun getLayoutId() = R.layout.activity_shopping_list_details
}