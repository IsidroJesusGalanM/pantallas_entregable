package com.example.ambigoo_pantalla_preguntas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ambigoo_pantalla_preguntas.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        setup()
        return binding.root
    }

    private fun setup() {
        binding.buttonNav.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

        }
    }


}