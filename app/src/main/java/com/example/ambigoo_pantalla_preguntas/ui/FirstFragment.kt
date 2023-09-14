package com.example.ambigoo_pantalla_preguntas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ambigoo_pantalla_preguntas.FirstViewModel
import com.example.ambigoo_pantalla_preguntas.R
import com.example.ambigoo_pantalla_preguntas.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {
    private val viewModel: FirstViewModel by viewModels()
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        binding.radioGroupObjetive.clearCheck()
        setup()
        return binding.root
    }

    private fun setup() {
        binding.radioGroupObjetive.setOnCheckedChangeListener { radioGroup, selected ->
            val selectedRadio = view?.findViewById<RadioButton>(selected)
            val selectedValue = selectedRadio?.text.toString()
            binding.next.visibility = View.VISIBLE
            viewModel.setData(selectedValue)
        }
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }



}