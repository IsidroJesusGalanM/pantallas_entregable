package com.example.ambigoo_pantalla_preguntas

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FirstViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    fun setData(objetive: String) {
        val prefs = sharedPreferences.edit()
        prefs.putString("objetivo", objetive)
        prefs.apply()
    }
}