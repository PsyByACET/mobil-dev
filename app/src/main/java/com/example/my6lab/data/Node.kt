package com.example.my6lab.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "node_table")
data class Node (
    @PrimaryKey(autoGenerate = true) @NonNull val id: Int,
    @ColumnInfo(name = "value") val value: Int,
    @ColumnInfo(name = "nodes") var nodes: List<Node>
)