package com.example.ambigoo_pantalla_preguntas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ambigoo_pantalla_preguntas.FourViewModel
import com.example.ambigoo_pantalla_preguntas.R
import com.example.ambigoo_pantalla_preguntas.databinding.FragmentFourBinding

class FourFragment : Fragment() {
    private val viewModel: FourViewModel by viewModels()
    private lateinit var binding: FragmentFourBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFourBinding.inflate(layoutInflater,container,false)
        setup()
        return binding.root
    }

    private fun setup() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fourFragment_to_thirdFragment)
        }
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_fourFragment_to_fiveFragment)
        }
    }

}