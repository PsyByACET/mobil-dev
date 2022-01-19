package com.example.my6lab.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NodeConverter {

    @TypeConverter
    fun fromNode (nodes: List<Node>): String {
        return Gson().toJson(nodes)
    }

    @TypeConverter
    fun toNode (nodes: String): List<Node>{
        val listType = object : TypeToken<List<Node>>() {}.type
        return Gson().fromJson(nodes, listType)
    }
}