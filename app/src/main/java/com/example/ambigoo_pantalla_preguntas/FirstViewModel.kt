package com.example.ambigoo_pantalla_preguntas

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class FirstViewModel @Inject constructor(
    private val juxx: AmbigooApp,
    private val sharedPreferences: SharedPreferences) : ViewModel() {

    fun setData(objetive: String) {
        val prefs = sharedPreferences.edit()
        prefs.putString("objetivo", objetive)
        prefs.apply()

        Toast.makeText(juxx, objetive.toString(), Toast.LENGTH_SHORT).show()
    }
}