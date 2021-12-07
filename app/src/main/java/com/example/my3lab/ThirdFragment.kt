package com.example.my3lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.my3lab.databinding.ThirdFragmentBinding


class ThirdFragment : Fragment() {
    lateinit var binding: ThirdFragmentBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = ThirdFragmentBinding.inflate(inflater)

        binding.multiplyButt.setOnClickListener {
            dataModel.action.value = "*"
            openLastFragment()
        }
        binding.devideButt.setOnClickListener {
            dataModel.action.value = "/"
            openLastFragment()
        }
        binding.plusButt.setOnClickListener {
            dataModel.action.value = "+"
            openLastFragment()
        }
        binding.minusButt.setOnClickListener {
            dataModel.action.value = "-"
            openLastFragment()
        }

        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.butt2.isEnabled = true
        mainActivity.binding.butt3.isEnabled = true
        mainActivity.binding.butt4.isEnabled = false
        mainActivity.binding.backButt.isEnabled = true
        mainActivity.binding.nextButt.isEnabled = true
        return binding.root
    }

    private fun openLastFragment() {
        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.fragment_container, FourthFragment())
        fr?.addToBackStack("4")
        fr?.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThirdFragment()

    }
}