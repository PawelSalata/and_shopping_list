package com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable

import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.ui.components.recycler_view.BaseRVAdapter
import com.pawelsalata.shoppinglist.ui.components.recycler_view.ViewHolder

/**
 * Created by LETTUCE on 30.12.2017.
 */
class ShowShoppingItemsRVAdapter(var shoppingItems: List<Item>) : BaseRVAdapter() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }


    override fun getObjForPosition(position: Int): Any {
        return shoppingItems[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_show_shopping_item
    }

    override fun getItemCount(): Int {
        return shoppingItems.size
    }
}