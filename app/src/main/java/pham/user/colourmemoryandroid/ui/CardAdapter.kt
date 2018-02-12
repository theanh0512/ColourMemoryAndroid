package pham.user.colourmemoryandroid.ui

import android.databinding.DataBindingUtil
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pham.user.colourmemoryandroid.R
import pham.user.colourmemoryandroid.databinding.ListItemCardBinding
import pham.user.colourmemoryandroid.ui.common.DataBoundListAdapter
import pham.user.colourmemoryandroid.util.Constants
import pham.user.colourmemoryandroid.vo.Card

/**
 * Created by Pham on 12/2/18.
 */

class CardAdapter(private val cardOnClickCallback: CardOnClickCallback?) :
        DataBoundListAdapter<Card, ListItemCardBinding>() {

    override fun createBinding(parent: ViewGroup): ListItemCardBinding {
        val binding = DataBindingUtil.inflate<ListItemCardBinding>(LayoutInflater.from(parent.context),
                R.layout.list_item_card, parent, false)!!
        binding.root.setOnClickListener {
            val card = binding.card
            if (card != null && cardOnClickCallback != null) {
                cardOnClickCallback.onClick(card)
                Log.e("card",binding.card.state.toString())
                binding.imageViewCardOpen.apply {
                    if(card.state==Constants.CardState.OPEN.value)
                        visibility = View.VISIBLE
                }
//                binding.imageViewCheck.apply {
//                    visibility = if (visibility == View.GONE) View.VISIBLE
//                    else View.GONE
//                }
            }
        }
        return binding
    }

    override fun bind(binding: ListItemCardBinding, item: Card) {
        binding.card = item
    }

    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.state == newItem.state
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.state == newItem.state && oldItem.content == newItem.content
    }

    interface CardOnClickCallback {
        fun onClick(card: Card)
    }
}