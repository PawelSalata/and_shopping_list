package com.pawelsalata.shoppinglist.ui.shopping_lists.active

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.pawelsalata.shoppinglist.data.model.ShoppingList
import com.pawelsalata.shoppinglist.ui.ShoppingListsInterface
import com.pawelsalata.shoppinglist.utils.visible
import kotlinx.android.synthetic.main.fragment_shopping_lists.*

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ActiveShoppingListsFragment : Fragment(), ShoppingListsInterface.View{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListFAB.visible()
        addListFAB.setOnClickListener { addShoppingList() }
    }

    fun addShoppingList() {

    }

    override fun openShoppingList(shoppingList: ShoppingList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}