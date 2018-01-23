package com.pawelsalata.shoppinglist.ui.list

import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.util.DiffUtil
import android.view.View
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.entities.ShoppingList
import com.pawelsalata.shoppinglist.ui.base.BaseRVAdapter
import com.pawelsalata.shoppinglist.ui.components.recycler_view.ViewHolder
import com.pawelsalata.shoppinglist.utils.DiffCallback
import kotlinx.android.synthetic.main.item_active_shopping_list.view.*

/**
 * Created by LETTUCE on 23.01.2018.
 */
class ShoppingListsAdapter : BaseRVAdapter() {

    var shoppingLists: List<ShoppingList> = ArrayList()
    lateinit var listener: UserActions

    fun updateList(newList: List<ShoppingList>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(shoppingLists, newList))
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val transitionListName = Pair.create(holder.itemView.listNameTV as View, ViewCompat.getTransitionName(holder.itemView.listNameTV))
        holder.itemView.cardView.setOnClickListener { listener.onShoppingListClick(shoppingLists[holder.adapterPosition], transitionListName) }
        holder.itemView.archiveBtnVG?.setOnClickListener { listener.onArchiveListClick(shoppingLists[holder.adapterPosition]) }
    }

    override fun getObjForPosition(position: Int): Any {
        return shoppingLists[position]
    }

    override fun getItemCount(): Int {
        return shoppingLists.size
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return if (shoppingLists[position].archived) {
            R.layout.item_archived_shopping_list
        } else {
            R.layout.item_active_shopping_list
        }
    }

    interface UserActions {
        fun onShoppingListClick(shoppingList: ShoppingList, transition: Pair<View, String>)
        fun onArchiveListClick(shoppingList: ShoppingList)
    }
}