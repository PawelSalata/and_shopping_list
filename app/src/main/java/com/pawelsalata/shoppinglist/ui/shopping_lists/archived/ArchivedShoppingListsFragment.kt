package com.pawelsalata.shoppinglist.ui.shopping_lists.archived

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.pawelsalata.shoppinglist.R.id.addListFAB
import com.pawelsalata.shoppinglist.data.model.ShoppingList
import com.pawelsalata.shoppinglist.ui.ShoppingListsInterface
import com.pawelsalata.shoppinglist.ui.shopping_lists.ShoppingListsViewModel
import com.pawelsalata.shoppinglist.utils.gone
import kotlinx.android.synthetic.main.fragment_shopping_lists.*

/**
 * Created by LETTUCE on 29.12.2017.
 */
class ArchivedShoppingListsFragment : ShoppingListsViewModel(), ShoppingListsInterface.View{
    override fun isAddListFABVisible(): Boolean = false


    override fun openShoppingList(shoppingList: ShoppingList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}