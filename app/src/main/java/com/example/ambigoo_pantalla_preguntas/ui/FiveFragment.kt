package com.example.ambigoo_pantalla_preguntas.ui

import android.app.Application
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ambigoo_pantalla_preguntas.FiveViewModel
import com.example.ambigoo_pantalla_preguntas.R
import com.example.ambigoo_pantalla_preguntas.databinding.FragmentFiveBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FiveFragment : Fragment() {
    private val viewModel: FiveViewModel by viewModels()
    private lateinit var binding: FragmentFiveBinding
    private var arrayAllergy = ArrayList<String>()

    private var huevoController = false
    private var mariscosController = false
    private var lactosaController = false
    private var glutenController = false
    private var frutosController = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFiveBinding.inflate(layoutInflater,container,false)
        setup()
        return binding.root
    }
    private fun setup() {
        initObservers()
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fiveFragment_to_fourFragment)
        }

        binding.next.setOnClickListener {

            viewModel.getSharedPreferences(arrayAllergy)

        }


        binding.huevo.setOnClickListener {
            huevoController = !huevoController
            if (huevoController){
                trueCheck(binding.huevo,binding.textHuevos,binding.imageHuevos)
                arrayAllergy.add("Huevo")
            }else{
                falseCheck(binding.huevo,binding.textHuevos,binding.imageHuevos)
                arrayAllergy.remove("Huevo")
            }
        }
        binding.mariscos.setOnClickListener {
            mariscosController = !mariscosController
            if (mariscosController){
                trueCheck(binding.mariscos,binding.textMar,binding.imageMar)
                arrayAllergy.add("Mariscos")
            }else{
                falseCheck(binding.mariscos,binding.textMar,binding.imageMar)
                arrayAllergy.remove("Mariscos")
            }
        }
        binding.lact.setOnClickListener {
            lactosaController = !lactosaController
            if (lactosaController){
                trueCheck(binding.lact,binding.textLact,binding.imageLact)
                arrayAllergy.add("Lactosa")
            }else{
                falseCheck(binding.lact,binding.textLact,binding.imageLact)
                arrayAllergy.remove("Lactosa")
            }
        }

        binding.gluten.setOnClickListener {
            glutenController = !glutenController
            if (glutenController){
                trueCheck(binding.gluten,binding.textGluten,binding.imageGluten)
                arrayAllergy.add("Gluten")
            }else{
                falseCheck(binding.gluten,binding.textGluten,binding.imageGluten)
                arrayAllergy.remove("Gluten")
            }
        }
        binding.frutos.setOnClickListener {
            frutosController =!frutosController
            if (frutosController){
                trueCheck(binding.frutos,binding.textFrutos,binding.imageFrutos)
                arrayAllergy.add("Frutos")
            }else{
                falseCheck(binding.frutos,binding.textFrutos,binding.imageFrutos)
                arrayAllergy.remove("Frutos")
            }
        }
    }

    private fun initObservers() {
        viewModel.success.observe(viewLifecycleOwner){success ->
            if (success){
                Toast.makeText(requireContext(), "Insertado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "No se inserto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun trueCheck(linear:LinearLayout,text: TextView,image: ImageView){
        text.setTextColor(resources.getColor(R.color.white))
        linear.setBackgroundResource(R.drawable.bg_buttons_orange)
        when(image){
            binding.imageHuevos -> binding.imageHuevos.setImageResource(R.drawable.huevo_true)
            binding.imageMar -> binding.imageMar.setImageResource(R.drawable.mar_true)
            binding.imageLact -> binding.imageLact.setImageResource(R.drawable.lact_true)
            binding.imageGluten -> binding.imageGluten.setImageResource(R.drawable.gluten_true)
            binding.imageFrutos -> binding.imageFrutos.setImageResource(R.drawable.frutos_true)
        }
    }
    private fun falseCheck(linear: LinearLayout,text:TextView,image:ImageView){
        text.setTextColor(resources.getColor(R.color.black))
        linear.setBackgroundResource(R.drawable.bg_edit_text)
        when(image){
            binding.imageHuevos -> binding.imageHuevos.setImageResource(R.drawable.huevo_false)
            binding.imageMar -> binding.imageMar.setImageResource(R.drawable.mar_false)
            binding.imageLact -> binding.imageLact.setImageResource(R.drawable.lact_falso)
            binding.imageGluten -> binding.imageGluten.setImageResource(R.drawable.gluten_false)
            binding.imageFrutos -> binding.imageFrutos.setImageResource(R.drawable.frutos_false)
        }
    }




}