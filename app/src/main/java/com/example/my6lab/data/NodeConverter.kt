package com.example.my6lab.data

import androidx.room.TypeConverter
import com.example.my6lab.data.models.Node
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NodeConverter {

    @TypeConverter
    fun fromNode (nodes: MutableList<Node>): String {
        return Gson().toJson(nodes)
    }

    @TypeConverter
    fun toNode (nodes: String): MutableList<Node>{
        val listType = object : TypeToken<MutableList<Node>>() {}.type
        return Gson().fromJson(nodes, listType)
    }
}