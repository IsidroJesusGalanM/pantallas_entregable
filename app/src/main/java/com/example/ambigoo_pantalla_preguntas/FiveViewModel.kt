package com.example.ambigoo_pantalla_preguntas

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FiveViewModel @Inject constructor(private val sharedPreferences: SharedPreferences,private val firestore: FirebaseFirestore): ViewModel() {
    val collection = "USERS"

    private var _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean>
        get() = _success
    fun getSharedPreferences(arreglo: ArrayList<String>){
        val prefs = sharedPreferences
        val objective = prefs.getString("objetivo","")
        val gender = prefs.getString("gender","")
        val experience = prefs.getString("exp","")
        val name = prefs.getString("name","")
        val date = prefs.getString("date","")

        uploadData(objective.toString(), gender.toString(),
            experience.toString(), name.toString(), date.toString(),arreglo)

    }

    private fun uploadData(
        objective: String,
        gender: String,
        experience: String,
        name: String,
        date: String,
        arreglo: ArrayList<String>) {

        var formattedName = name.replace("\\s".toRegex(), "")
        firestore.collection(collection).document(formattedName).set(
            hashMapOf(
                "name" to name
            )
        ).addOnSuccessListener {
            addSubData(objective,gender,experience,date,arreglo,formattedName)

        }.addOnFailureListener {
            Log.e("Firebase_error", "failed to add user")
            }
    }

    private fun addSubData(
        objective: String,
        gender: String,
        experience: String,
        date: String,
        arreglo: ArrayList<String>,
        nameDocument:String
    ) {
        firestore.collection(collection).document(nameDocument)
            .collection("userData").document("userInfo").set(
                hashMapOf(
                    "objective" to objective,
                    "gender" to gender,
                    "experience" to experience,
                    "birthday" to date,
                    "allergy" to arreglo
                )
            ).addOnSuccessListener {
                _success.value = true
                Log.e("Firebase", "successfully")
            }.addOnFailureListener {
                _success.value = false
                Log.e("Firebase", "Failed")
            }
    }
}