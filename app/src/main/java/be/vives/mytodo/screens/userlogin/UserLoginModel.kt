package be.vives.mytodo.screens.userlogin

import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import be.vives.mytodo.models.User
import be.vives.mytodo.screens.utils.MockupUser

class UserLoginModel: ViewModel() {

    var user = MutableLiveData<User?>()
    var loginError = MutableLiveData<String?>()
    var errorPassword = MutableLiveData<String?>()

    var userName = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    private var mockupUser = MutableLiveData<MockupUser>()

    var navigateBack = MutableLiveData<Boolean>()

    init {
        mockupUser.value = MockupUser()
        mockupUser.value?.error?.observeForever(Observer {
            //it?.let {

                loginError.value = it
            //}
        })
        navigateBack.value = false
        userName.value=""
        password.value=""
    }

    fun btnLoginClicked() {
        if (userName.value.isNullOrBlank()) {
            loginError.value = "Gebruikersnaam mag niet leeg zijn."
        } else {
            loginError.value = null
        }
        if (password.value.isNullOrBlank()) {
            errorPassword.value = "Paswoord mag niet leeg zijn."

        } else  {
            errorPassword.value = null
        }

        if (errorPassword.value.isNullOrBlank() && loginError.value.isNullOrBlank()) {
            user.value = mockupUser.value?.getUser(userName.value, password.value)
        }
    }

    fun btnCancelClicked() {
        navigateBack.value = true
    }
}