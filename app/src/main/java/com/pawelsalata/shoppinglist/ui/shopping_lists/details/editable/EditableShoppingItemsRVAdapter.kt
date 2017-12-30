package com.pawelsalata.shoppinglist.ui.shopping_lists.details.editable

import android.text.Editable
import android.view.View
import android.widget.EditText
import com.pawelsalata.shoppinglist.R
import com.pawelsalata.shoppinglist.data.entities.Item
import com.pawelsalata.shoppinglist.ui.components.recycler_view.BaseRVAdapter
import com.pawelsalata.shoppinglist.ui.components.recycler_view.ViewHolder
import com.pawelsalata.shoppinglist.utils.extensions.logd
import kotlinx.android.synthetic.main.item_shopping_item.view.*

/**
 * Created by LETTUCE on 30.12.2017.
 */
class EditableShoppingItemsRVAdapter(var shoppingItems: MutableList<Item>) : BaseRVAdapter() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position == 0) holder.itemView.shoppingItemET.let {
            it.requestFocus()
            it.text.clear()
        }
        holder.itemView.shoppingItemET.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && position  <= itemCount) {
                shoppingItems[position].text = (view as EditText).text.toString()
            }
        }
    }

    fun addListItem(item: Item) {
//        if (itemCount > 0) {
//            shoppingItems[0].text =
//        }
        shoppingItems.add(0, item)
        notifyDataSetChanged()
    }

    override fun getObjForPosition(position: Int): Any {
        return shoppingItems[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_shopping_item
    }

    override fun getItemCount(): Int {
        return shoppingItems.size
    }
}