package com.pawelsalata.shoppinglist.ui.shopping_lists.details.show

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.databinding.ActivityShowShoppingListBinding
import com.pawelsalata.shoppinglist.ui.components.AndroidViewModelFactory
import com.pawelsalata.shoppinglist.ui.components.RecyclerViewMargin
import com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable.ShowShoppingItemsRVAdapter
import kotlinx.android.synthetic.main.activity_show_shopping_list.*

/**
 * Created by LETTUCE on 30.12.2017.
 */
class ShowShoppingListActivity : AppCompatActivity() {

    companion object {
        val EXTRA_SHOPPING_LIST_ID = "com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable.EXTRA_SHOPPING_LIST_ID"
        val EXTRA_SHOPPING_LIST_NAME = "com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable.EXTRA_SHOPPING_LIST_NAME"
    }

    private lateinit var viewModel: ShowShoppingListViewModel
    private lateinit var viewBinding: ActivityShowShoppingListBinding
    private lateinit var shoppingItemsAdapter: ShowShoppingItemsRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityShowShoppingListBinding>(this, R.layout.activity_show_shopping_list)
                .also { viewBinding = it!! }
        ViewModelProviders.of(this, AndroidViewModelFactory(application)).get(ShowShoppingListViewModel::class.java)
                .also { viewModel = it }

        viewModel.init(intent.getIntExtra(EXTRA_SHOPPING_LIST_ID, -1))
        setupToolbar(intent.getStringExtra(EXTRA_SHOPPING_LIST_NAME))
        setupRecyclerView()
    }

    private fun setupToolbar(title: String?) {
        toolbar_title.text = title
    }

    private fun setupRecyclerView() {
        shoppingItemsRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        shoppingItemsAdapter = ShowShoppingItemsRVAdapter(viewModel.shoppingListLiveData.itemsList)
        shoppingItemsRV.adapter = shoppingItemsAdapter
        shoppingItemsRV.addItemDecoration(RecyclerViewMargin(20, shoppingItemsAdapter.itemCount, LinearLayoutManager.VERTICAL))
    }
}