package com.example.whac_a_mole

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WAMViewModelFactory (
    private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WAMViewModel::class.java)) {
            return WAMViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}