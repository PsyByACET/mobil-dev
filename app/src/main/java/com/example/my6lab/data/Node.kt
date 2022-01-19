package com.example.my6lab.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "node_table")
data class Node (
    @PrimaryKey
    val value: Int,
    var nodes: MutableList<Node>
)