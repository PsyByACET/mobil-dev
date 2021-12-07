package com.example.my4lab


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my4lab.databinding.ActivityMainBinding

import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = verticalLinearLayoutManager
        binding.recyclerView.adapter =
            Adapter(Holder.createCollectionItems(), ::showCardMessage, ::showBuyMessage)

    }

    private fun showCardMessage(pizza: Pizza) {
        Snackbar.make(binding.root, "Нажата карточка: " + pizza.name, 1600).show()
    }
    private fun showBuyMessage(pizza: Pizza) {
        Snackbar.make(binding.root, "Вы добавили в корзину:  " + pizza.name, 1600).show()
    }
}
