package com.example.ambigoo_pantalla_preguntas

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) : ViewModel() {

    fun setDate(date:String,){
        val prefs = sharedPreferences.edit()
        prefs.putString("date", date)
        prefs.apply()
    }

    fun setName(name:String){
        val prefs = sharedPreferences.edit()
        prefs.putString("name", name)
        prefs.apply()
    }

}