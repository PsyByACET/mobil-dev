package com.example.my4lab

import androidx.annotation.DrawableRes
import kotlin.collections.ArrayList

object Holder {
    private val names = arrayOf(
        "Пицца пепперони",
        "Пицца 4 сыра",
        "Пицца мясная",
        "Пицца 4 сезона",
        "Пицца цыпленок барбекю",
        "Пицца ветчина и грибы",
        "Пицца цыпленок ранч",
    )
    private val prices = arrayOf(
        "500 ₽",
        "600 ₽",
        "600 ₽",
        "450 ₽",
        "470 ₽",
        "440 ₽",
        "430 ₽",
    )
    private val texts = arrayOf(
        "Пикантная пепперони, увеличенная порция моцареллы, томатный соус",
        "Сыр блю чиз, сыры чеддер и пармезан, моцарелла, соус альфредо",
        "Пикантная пепперони, цыпленок, острая чоризо, бекон, митболы, моцарелла, томатный соус",
        "Увеличенная порция моцареллы, ветчина, пикантная пепперони, кубики брынзы, томаты, шампиньоны, итальянские травы, томатный соус",
        "Цыпленок, бекон, соус барбекю, красный лук, моцарелла, томатный соус",
        "Ветчина, шампиньоны, увеличенная порция моцареллы, томатный соус",
        "Цыпленок, ветчина, соус ранч, моцарелла, томаты, чеснок",
    )
    private val images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7
    )

    fun createCollectionItems(): ArrayList<Pizza> {
        val items: ArrayList<Pizza> = ArrayList<Pizza>()
        for (i in 0..6) {
            val item = Pizza (
                names[i],
                prices[i],
                texts[i],
                images[i],
            )
            items.add(item)
        }
        return items
    }
}

data class Pizza (
    val name: String,
    val price: String,
    val text: String,
    @DrawableRes val imageDrawableRes: Int
)