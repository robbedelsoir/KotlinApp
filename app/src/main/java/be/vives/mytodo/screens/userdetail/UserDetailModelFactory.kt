package be.vives.mytodo.screens.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.vives.mytodo.models.User

class UserDetailModelFactory(private val user: User, private val activeText:String, private val notActiveText: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailModel::class.java)) {
            return UserDetailModel(
                user,
                activeText,
                notActiveText
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}