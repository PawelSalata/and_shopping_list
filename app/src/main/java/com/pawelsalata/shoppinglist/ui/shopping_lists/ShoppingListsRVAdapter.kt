package com.pawelsalata.shoppinglist.ui.shopping_lists

import com.pawelsalata.shoppinglist.BR.listener
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.ui.components.recycler_view.BaseRVAdapter
import com.pawelsalata.shoppinglist.ui.components.recycler_view.ViewHolder

/**
 * Created by LETTUCE on 30.12.2017.
 */
class ShoppingListsRVAdapter(var shoppingLists: List<ShoppingListWithItems>, val listener: ShoppingListsInterface.UserActions) : BaseRVAdapter() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener { listener.onShoppingListClick(shoppingLists[holder.adapterPosition]) }
    }

    override fun getObjForPosition(position: Int): Any {
        return shoppingLists[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_shopping_list
    }

    override fun getItemCount(): Int {
        return shoppingLists.size
    }
}