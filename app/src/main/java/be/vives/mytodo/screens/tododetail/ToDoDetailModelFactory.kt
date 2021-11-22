package be.vives.mytodo.screens.tododetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.vives.mytodo.models.ToDo

class ToDoDetailModelFactory(private val toDo: ToDo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoDetailModel::class.java)) {
            return ToDoDetailModel(toDo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}