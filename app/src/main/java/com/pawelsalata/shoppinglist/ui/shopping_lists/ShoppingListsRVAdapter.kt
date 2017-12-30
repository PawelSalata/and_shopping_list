package com.pawelsalata.shoppinglist.ui.shopping_lists

import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.ui.components.recycler_view.BaseRVAdapter
import com.pawelsalata.shoppinglist.ui.components.recycler_view.ViewHolder

/**
 * Created by LETTUCE on 30.12.2017.
 */
abstract class ShoppingListsRVAdapter(var shoppingLists: List<ShoppingListWithItems>, val listener: ShoppingListsInterface.UserActions) : BaseRVAdapter() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }

    override fun getObjForPosition(position: Int): Any {
        return shoppingLists[position]
    }

    override fun getItemCount(): Int {
        return shoppingLists.size
    }
}