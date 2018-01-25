package com.pawelsalata.shoppinglist.ui.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.pawelsalata.shoppinglist.BR
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.databinding.FragmentShoppingListsBinding
import com.pawelsalata.shoppinglist.ui.base.BaseFragment
import com.pawelsalata.shoppinglist.ui.components.RecyclerViewMargin
import com.pawelsalata.shoppinglist.ui.details.ShoppingListDetailsActivity
import com.pawelsalata.shoppinglist.ui.main.MainActivity
import com.pawelsalata.shoppinglist.utils.ShoppingListState
import com.pawelsalata.shoppinglist.utils.extensions.launchActivity
import javax.inject.Inject

/**
 * Created by LETTUCE on 22.01.2018.
 */
class ShoppingListsFragment: BaseFragment<FragmentShoppingListsBinding, ShoppingListsViewModel>(),
        ShoppingListsNavigator {

    @Inject
    lateinit var shoppingListViewModel: ShoppingListsViewModel

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var shoppingListsAdapter: ShoppingListsAdapter

    companion object {
        fun getInstance(state: ShoppingListState): ShoppingListsFragment {
            val fragment = ShoppingListsFragment()
            val bundle = Bundle()
            bundle.putBoolean("archived", state.getValue())
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shoppingListViewModel.navigator = this
        shoppingListViewModel.init(arguments.getBoolean("archived"))
        shoppingListsAdapter.listener = shoppingListViewModel
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        observeData()
    }

    override fun openShoppingListDetails(shoppingList: ShoppingList, transition: Pair<View, String>) {
        val options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(activity as MainActivity, transition)
        activity?.launchActivity<ShoppingListDetailsActivity>(options.toBundle()) {
            putExtra(ShoppingListDetailsActivity.EXTRA_SHOPPING_LIST_ID, shoppingList.id)
            putExtra(ShoppingListDetailsActivity.EXTRA_SHOPPING_LIST_NAME, shoppingList.name)
        }
    }

    private fun setup() {
        getViewBinding().shoppingListsRV.adapter = shoppingListsAdapter
        getViewBinding().shoppingListsRV.layoutManager = layoutManager
        getViewBinding().shoppingListsRV.addItemDecoration(RecyclerViewMargin(40, shoppingListsAdapter.itemCount, layoutManager.orientation))
    }

    private fun observeData() {
        shoppingListViewModel.shoppingListsLiveData.observe(this, Observer { shoppingLists ->
            shoppingLists?.let { shoppingListsAdapter.updateList(it) }
        })
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): ShoppingListsViewModel = shoppingListViewModel

    override fun getLayoutId(): Int = R.layout.fragment_shopping_lists
}