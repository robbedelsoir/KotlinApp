package be.vives.mytodo.screens.utils

import androidx.lifecycle.MutableLiveData
import be.vives.mytodo.models.User

 class MockupUser {

    private val user1 = User(2, "DirkHostens", "Dirk","Hostens", "password", true)
    private val user2 = User(1, "FrankDebare", "Frank","Debaere", "password", true)
    private val users = arrayOf(user1, user2)
    var error = MutableLiveData<String>()

     fun getUser(userName: String?, password: String?) : User? {
         var user : User? = null
        var filterUsers = users.filter {
            it.userName.lowercase().equals(userName?.lowercase()) &&  it.password.equals(password)
        }
        if (filterUsers.isEmpty()) {
            error.value = "Fout bij inloggen. Gebruikersnaam of paswoord niet correct."
        } else {
            error.value = null
            user = filterUsers[0]
        }
         return user
    }
}