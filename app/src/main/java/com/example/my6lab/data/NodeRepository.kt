package com.example.my6lab.data

import com.example.my6lab.data.Node
import com.example.my6lab.data.NodeDao

class NodeRepository(private val nodeDao: NodeDao) {

    val readAllData = nodeDao.readAllData()

    suspend fun addNode(node: Node){
        nodeDao.addNode(node)
    }

    suspend fun updateNode(value: Int, nodes: MutableList<Node>){
        nodeDao.updateNode(value, nodes)
    }
}