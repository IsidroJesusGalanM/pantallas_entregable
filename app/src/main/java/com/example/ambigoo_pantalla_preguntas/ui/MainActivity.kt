package com.example.ambigoo_pantalla_preguntas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambigoo_pantalla_preguntas.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}