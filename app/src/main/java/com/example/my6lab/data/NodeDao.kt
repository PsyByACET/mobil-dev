package com.example.my6lab.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.my6lab.data.models.Node

@Dao

interface NodeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNode(node: Node)

    @Query("SELECT * FROM node_table ORDER BY value ASC")
    fun readAllData(): LiveData<MutableList<Node>>

    @Query("UPDATE node_table SET nodes=:nodes WHERE value=:value")
    suspend fun updateNode(value: Int, nodes: MutableList<Node>)

}