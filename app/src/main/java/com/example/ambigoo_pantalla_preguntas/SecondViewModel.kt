package com.example.ambigoo_pantalla_preguntas

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SecondViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) : ViewModel() {

    fun setData(gender:String){
        val prefs = sharedPreferences.edit()
        prefs.putString("gender", gender)
        prefs.apply()
    }
}