package com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.databinding.ActivityEditableShoppingListBinding
import com.pawelsalata.shoppinglist.ui.components.AndroidViewModelFactory
import com.pawelsalata.shoppinglist.ui.components.RecyclerViewMargin
import kotlinx.android.synthetic.main.activity_editable_shopping_list.*

/**
 * Created by LETTUCE on 30.12.2017.
 */
class EditableShoppingListActivity : AppCompatActivity(),
        EditableShoppingListInterface.UserActions  {
    companion object {
        val EXTRA_SHOPPING_LIST_ID = "com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable.EXTRA_SHOPPING_LIST_ID"
        val EXTRA_SHOPPING_LIST_NAME = "com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable.EXTRA_SHOPPING_LIST_NAME"
    }

    private lateinit var viewModel: EditableShoppingListViewModel
    private lateinit var viewBinding: ActivityEditableShoppingListBinding
    private lateinit var shoppingItemsAdapter: ShoppingItemsRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityEditableShoppingListBinding>(this, R.layout.activity_editable_shopping_list)
                .also { viewBinding = it!! }
        ViewModelProviders.of(this, AndroidViewModelFactory(application)).get(EditableShoppingListViewModel::class.java)
                .also { viewModel = it }
        viewBinding.viewModel = viewModel
        viewBinding.listener = this

        viewModel.init(intent.getIntExtra(EXTRA_SHOPPING_LIST_ID, -1))
        setupToolbar(intent.getStringExtra(EXTRA_SHOPPING_LIST_NAME))
        setupRecyclerView()
    }

//    override fun onStart() {
//        super.onStart()
//        viewModel.shoppingListLiveData.observe(this, Observer { shoppingList ->
//            shoppingItemsAdapter.shoppingItems = shoppingList?.itemsList ?: ArrayList()
//            shoppingItemsAdapter.notifyDataSetChanged()
//        })
//    }
//
    override fun onStop() {
//        viewModel.saveShoppingList()
        super.onStop()
    }

    private fun setupToolbar(title: String?) {
        toolbar_title.setText(title.toString())
    }

    override fun onAddItemClick(v: View) {
        shoppingItemsAdapter.addListItem(viewModel.createItem())
//        shoppingItemsAdapter.notifyDataSetChanged()
    }

    override fun onSaveListClick(v: View) {
        viewModel.shoppingListLiveData.shoppingList.name = toolbar_title.text.toString()
        viewModel.saveShoppingList()
    }

    private fun setupRecyclerView() {
        shoppingItemsRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        shoppingItemsAdapter = ShoppingItemsRVAdapter(viewModel.shoppingListLiveData.itemsList)
        shoppingItemsRV.adapter = shoppingItemsAdapter
        shoppingItemsRV.addItemDecoration(RecyclerViewMargin(20, shoppingItemsAdapter.itemCount, LinearLayoutManager.VERTICAL))
    }
}