package com.example.ambigoo_pantalla_preguntas.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.ambigoo_pantalla_preguntas.AmbigooApp
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context): AmbigooApp{
        return context as AmbigooApp
    }

    @Singleton
    @Provides
    fun provideFirebaseFirestore():FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext shared: Context): SharedPreferences{
        return shared.getSharedPreferences("mi_saved_data",Context.MODE_PRIVATE)
    }

}