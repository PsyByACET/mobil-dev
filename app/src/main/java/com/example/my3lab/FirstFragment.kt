package com.example.my3lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.my3lab.databinding.FirstFragmentBinding


class FirstFragment : Fragment() {
    lateinit var binding: FirstFragmentBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FirstFragmentBinding.inflate(inflater)
        if (dataModel.firstNumber.value != null) {
            binding.firstData.setText(dataModel.firstNumber.value.toString())
        }
        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.butt2.isEnabled = false
        mainActivity.binding.butt3.isEnabled = false
        mainActivity.binding.butt4.isEnabled = false
        mainActivity.binding.backButt.isEnabled = false
        mainActivity.binding.nextButt.isEnabled = true
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dataModel.firstNumber.value = binding.firstData.text.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}