package com.example.ambigoo_pantalla_preguntas.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ambigoo_pantalla_preguntas.R
import com.example.ambigoo_pantalla_preguntas.ThirdViewModel
import com.example.ambigoo_pantalla_preguntas.databinding.FragmentThirdBinding
import com.example.ambigoo_pantalla_preguntas.utils.DatePickerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : Fragment() {
    private val viewModel: ThirdViewModel by viewModels()
    private lateinit var binding: FragmentThirdBinding

    private var date = ""
    private var name = ""
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
        binding.bornPicker.setOnClickListener {
            val datePicker = DatePickerFragment{day, month, year -> daySelected(day,month,year)  }
            datePicker.show(requireFragmentManager(),"datePicker")
        }

        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_fourFragment2)
        }
        binding.name.addTextChangedListener ( object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                name = p0.toString()
                viewModel.setName(name)
                if (!p0.toString().isNullOrBlank()){
                    if(checkData(name, date)){
                        binding.next.visibility = View.VISIBLE
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun checkData(name:String,date:String): Boolean {
        return name.isNotEmpty() && date.isNotEmpty()
    }

    private fun daySelected(day: Int, month: Int, year: Int) {
        val monthName = monthSelected(month + 1)
        val formatDay = String.format("%02d",day)
        val formatMonth = String.format("%02d",month + 1)
        val text = "$day de $monthName de $year"
        val dateFormat = "$formatDay/$formatMonth/$year"
        date = dateFormat
        binding.bornDate.setText(text)

        viewModel.setDate(date)
        if (checkData(name, date)){
            binding.next.visibility = View.VISIBLE
        }
    }

    private fun monthSelected(month: Int): String {
        return when (month) {
            1 -> "Enero"
            2 -> "Febrero"
            3 -> "Marzo"
            4 -> "Abril"
            5 -> "Mayo"
            6 -> "Junio"
            7 -> "Julio"
            8 -> "Agosto"
            9 -> "Septiembre"
            10 -> "Octubre"
            11 -> "Noviembre"
            12 -> "Diciembre"
            else -> "Mes inválido"
        }
    }


}