package com.example.my3lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.my3lab.databinding.SecondFragmentBinding


class SecondFragment : Fragment() {
    lateinit var binding: SecondFragmentBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = SecondFragmentBinding.inflate(inflater)
        if (dataModel.secondNumber.value != null) {
            binding.secondData.setText(dataModel.secondNumber.value.toString())
        }
        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.butt2.isEnabled = true
        mainActivity.binding.butt3.isEnabled = false
        mainActivity.binding.butt4.isEnabled = false
        mainActivity.binding.backButt.isEnabled = true
        mainActivity.binding.nextButt.isEnabled = true
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        dataModel.secondNumber.value = binding.secondData.text.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()

    }
}