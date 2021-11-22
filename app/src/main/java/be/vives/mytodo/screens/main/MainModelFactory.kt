package be.vives.mytodo.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainModel::class.java)) {
                return MainModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
