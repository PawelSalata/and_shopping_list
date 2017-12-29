package com.pawelsalata.shoppinglist.ui.shopping_lists.archived

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.model.ShoppingList
import com.pawelsalata.shoppinglist.databinding.FragmentShoppingListsBinding
import com.pawelsalata.shoppinglist.ui.shopping_lists.ShoppingListsInterface
import com.pawelsalata.shoppinglist.ui.shopping_lists.active.ActiveShoppingListsFragment

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ArchivedShoppingListsFragment : Fragment(), ShoppingListsInterface.View {
    companion object {
        val TAG = ArchivedShoppingListsFragment::class.java.simpleName
    }

    private lateinit var viewBinding: FragmentShoppingListsBinding
    private lateinit var viewModel: ArchivedShoppingListsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DataBindingUtil.inflate<FragmentShoppingListsBinding>(
                inflater,
                R.layout.fragment_shopping_lists,
                container,
                false)
                .also { viewBinding = it!! }
        ViewModelProviders.of(this).get(ArchivedShoppingListsViewModel::class.java)
                .also { viewModel = it }
        viewBinding.viewModel = viewModel
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun openShoppingList(shoppingList: ShoppingList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}