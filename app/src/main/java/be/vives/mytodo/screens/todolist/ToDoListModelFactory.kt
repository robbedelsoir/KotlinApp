package be.vives.mytodo.screens.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.vives.mytodo.models.User
import be.vives.mytodo.screens.userdetail.UserDetailModel

class ToDoListModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoListModel::class.java)) {
            return ToDoListModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}