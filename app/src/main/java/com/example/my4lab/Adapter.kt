package com.example.my4lab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import coil.transform.RoundedCornersTransformation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.my4lab.databinding.ItemBinding

class Adapter(
    var listpizza: List<Pizza>,
    private val clickCard: (Pizza) -> Unit,
    private val clickCardBuy: (Pizza) -> Unit
): RecyclerView.Adapter<Adapter.MyHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding, clickCard, clickCardBuy)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val pizza = listpizza[position]
        holder.bind(pizza)
    }
    override fun getItemCount(): Int {
        return listpizza.size
    }
    inner class MyHolder internal constructor(
        private val binding: ItemBinding,
        private val clickCard: (Pizza) -> Unit,
        private val clickCardBuy: (Pizza) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) = binding.run{
            name.text = pizza.name
            price.text = pizza.price
            text.text = pizza.text
            image.load(pizza.imageDrawableRes)
            binding.card.setOnClickListener {
                clickCard.invoke(pizza)
            }
            binding.buy.setOnClickListener {
                clickCardBuy.invoke(pizza)
            }
        }
    }
}