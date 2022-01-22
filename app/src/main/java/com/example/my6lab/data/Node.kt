package com.example.my6lab.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "node_table")
data class Node (
    @PrimaryKey
    val value: Int,
    var nodes: MutableList<Node>
): Parcelable