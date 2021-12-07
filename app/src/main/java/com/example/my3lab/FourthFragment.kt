package com.example.my3lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.my3lab.databinding.FouthFragmentBinding


class FourthFragment : Fragment() {
    lateinit var binding: FouthFragmentBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FouthFragmentBinding.inflate(inflater)

        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.butt2.isEnabled = true
        mainActivity.binding.butt3.isEnabled = true
        mainActivity.binding.butt4.isEnabled = true
        mainActivity.binding.backButt.isEnabled = true
        mainActivity.binding.nextButt.isEnabled = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var result: Double = 0.0
        var expression: String = dataModel.firstNumber.value.toString() + " " + dataModel.action.value.toString() + " " + dataModel.secondNumber.value.toString() + " = "
        super.onViewCreated(view, savedInstanceState)

        if(dataModel.action.value.toString() == "*" && dataModel.firstNumber.value.toString() != "" && dataModel.secondNumber.value.toString() != "") {
            result = dataModel.firstNumber.value!!.toDouble() * dataModel.secondNumber.value!!.toDouble()
        }
        if(dataModel.action.value.toString() == "/" && dataModel.firstNumber.value.toString() != "" && dataModel.secondNumber.value.toString() != "") {
            result = dataModel.firstNumber.value!!.toDouble() / dataModel.secondNumber.value!!.toDouble()
        }
        if(dataModel.action.value.toString() == "+" && dataModel.firstNumber.value.toString() != "" && dataModel.secondNumber.value.toString() != "") {
            result = dataModel.firstNumber.value!!.toDouble() + dataModel.secondNumber.value!!.toDouble()
        }
        if(dataModel.action.value.toString() == "-" && dataModel.firstNumber.value.toString() != "" && dataModel.secondNumber.value.toString() != "") {
            result = dataModel.firstNumber.value!!.toDouble() - dataModel.secondNumber.value!!.toDouble()
        }
        binding.answer.text = expression + result.toString()
        if(dataModel.action.value.toString() == null || dataModel.firstNumber.value.toString() == "" || dataModel.secondNumber.value.toString() == "") {
            binding.answer.text = "Вы заполнили не все данные, вернитесь назад и заполните их"
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = FourthFragment()

    }
}