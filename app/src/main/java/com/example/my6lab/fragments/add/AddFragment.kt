package com.example.my6lab.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.room.TypeConverters
import com.example.my6lab.R
import com.example.my6lab.data.Node
import com.example.my6lab.data.NodeConverter
import com.example.my6lab.data.NodeViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

@TypeConverters(NodeConverter::class)

class AddFragment : Fragment() {

    private lateinit var mNodeViewModel: NodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mNodeViewModel = ViewModelProvider(this).get(NodeViewModel::class.java)

        view.add_button.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val value = editTextNumber.text

        if(inputCheck(value)){
            //val node = Node(0, Integer.parseInt(value.toString()), String)
        }
    }

    private fun inputCheck(value: Editable): Boolean {
        return !(value.isEmpty())
    }
}