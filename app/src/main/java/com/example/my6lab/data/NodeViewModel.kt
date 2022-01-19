package com.example.my6lab.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NodeViewModel(application: Application): AndroidViewModel(application) {

    private val readAlldata: LiveData<List<Node>>
    private val repository: NodeRepository

    init {
        val nodeDao = NodeDatabase.getDatabase(application).nodeDao()
        repository = NodeRepository(nodeDao)
        readAlldata = repository.readAllData
    }

    fun addNode(node: Node){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNode(node)
        }
    }
}