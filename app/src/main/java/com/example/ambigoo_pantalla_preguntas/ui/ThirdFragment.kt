package com.example.ambigoo_pantalla_preguntas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ambigoo_pantalla_preguntas.R
import com.example.ambigoo_pantalla_preguntas.ThirdViewModel
import com.example.ambigoo_pantalla_preguntas.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private val viewModel: ThirdViewModel by viewModels()
    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(layoutInflater,container,false)
        setup()
        return binding.root
    }

    private fun setup() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_fourFragment2)
        }
    }


}