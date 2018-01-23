package com.pawelsalata.shoppinglist.ui.shopping_lists.active

import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.view.View
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.model.ShoppingListWithItems
import com.pawelsalata.shoppinglist.ui.components.recycler_view.ViewHolder
import com.pawelsalata.shoppinglist.ui.shopping_lists.ShoppingListsInterface
import com.pawelsalata.shoppinglist.ui.shopping_lists.ShoppingListsRVAdapter
import kotlinx.android.synthetic.main.item_active_shopping_list.view.*

/**
 * Created by LETTUCE on 30.12.2017.
 */
class ActiveShoppingListAdapter(shoppingLists: List<ShoppingListWithItems>, listener: ShoppingListsInterface.UserActions) :
        ShoppingListsRVAdapter(shoppingLists, listener) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val transitionListName = Pair.create(holder.itemView.listNameTV as View, ViewCompat.getTransitionName(holder.itemView.listNameTV))
        holder.itemView.cardView.setOnClickListener { listener.onShoppingListClick(shoppingLists[holder.adapterPosition], transitionListName) }
        holder.itemView.archiveBtnVG.setOnClickListener { listener.archiveList(shoppingLists[holder.adapterPosition]) }
}

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_active_shopping_list
    }

}