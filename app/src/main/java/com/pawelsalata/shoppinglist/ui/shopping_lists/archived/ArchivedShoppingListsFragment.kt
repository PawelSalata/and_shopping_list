package com.pawelsalata.shoppinglist.ui.shopping_lists.archived

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.databinding.FragmentShoppingListsBinding
import com.pawelsalata.shoppinglist.ui.components.AndroidViewModelFactory
import com.pawelsalata.shoppinglist.ui.components.RecyclerViewMargin
import com.pawelsalata.shoppinglist.ui.main.MainActivity
import com.pawelsalata.shoppinglist.ui.shopping_lists.ShoppingListsInterface
import com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable.EditableShoppingListActivity
import com.pawelsalata.shoppinglist.ui.shopping_lists.details.show.ShowShoppingListActivity
import com.pawelsalata.shoppinglist.utils.extensions.launchActivity
import com.pawelsalata.shoppinglist.utils.extensions.logd
import kotlinx.android.synthetic.main.fragment_shopping_lists.*

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ArchivedShoppingListsFragment : Fragment(), ShoppingListsInterface.UserActions {
    companion object {
        val TAG = ArchivedShoppingListsFragment::class.java.simpleName
    }

    private lateinit var viewBinding: FragmentShoppingListsBinding
    private lateinit var viewModel: ArchivedShoppingListsViewModel
    private lateinit var shoppingListsAdapter: ArchivedShoppingListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DataBindingUtil.inflate<FragmentShoppingListsBinding>(
                inflater,
                R.layout.fragment_shopping_lists,
                container,
                false)
                .also { viewBinding = it!! }
        ViewModelProviders.of(this, AndroidViewModelFactory(activity?.application))
                .get(ArchivedShoppingListsViewModel::class.java)
                .also { viewModel = it }
//        viewBinding.viewModel = viewModel
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.shoppingListsLiveData.observe(this, Observer { lists ->
            logd("List size: " + lists?.size)
            shoppingListsAdapter.shoppingLists = lists ?: ArrayList()
            shoppingListsAdapter.notifyDataSetChanged()
        })
    }

    override fun onStop() {
        viewModel.shoppingListsLiveData.removeObservers(this)
        super.onStop()
    }

    override fun onShoppingListClick(shoppingListWithItems: ShoppingListWithItems, transition: Pair<View, String>) {
        val options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(activity as MainActivity, transition)
        activity?.launchActivity<ShowShoppingListActivity>(options.toBundle()) {
            putExtra(EditableShoppingListActivity.EXTRA_SHOPPING_LIST_ID, shoppingListWithItems.shoppingList.id)
            putExtra(EditableShoppingListActivity.EXTRA_SHOPPING_LIST_NAME, shoppingListWithItems.shoppingList.name)
        }
    }

    private fun initRecyclerView() {
        shoppingListsRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        shoppingListsAdapter = ArchivedShoppingListAdapter(ArrayList(), this)
        shoppingListsRV.adapter = shoppingListsAdapter
        shoppingListsRV.addItemDecoration(RecyclerViewMargin(40, shoppingListsAdapter.itemCount, LinearLayoutManager.VERTICAL))
    }
}