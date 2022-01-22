package com.example.my6lab.data.repository

import com.example.my6lab.data.NodeDao
import com.example.my6lab.data.models.Node

class NodeRepository(private val nodeDao: NodeDao) {

    val readAllData = nodeDao.readAllData()

    suspend fun addNode(node: Node){
        nodeDao.addNode(node)
    }

    suspend fun updateNode(value: Int, nodes: MutableList<Node>){
        nodeDao.updateNode(value, nodes)
    }
}