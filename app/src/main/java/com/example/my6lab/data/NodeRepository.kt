package com.example.my6lab.data

import androidx.lifecycle.LiveData

class NodeRepository(private val nodeDao: NodeDao) {

    val readAllData: LiveData<List<Node>> = nodeDao.readAllData()

    suspend fun addNode(node: Node){
        nodeDao.addNode(node)
    }
}