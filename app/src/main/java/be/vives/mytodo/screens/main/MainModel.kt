package be.vives.mytodo.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.mytodo.models.User

class MainModel: ViewModel() {
    private val _navigateToUserDetail = MutableLiveData<Boolean>()
    val navigateToUserDetail : LiveData<Boolean>
        get() {return _navigateToUserDetail}

    private val _navigateToToDoDetail = MutableLiveData<Boolean>()
    val navigateToToDoDetail : LiveData<Boolean>
        get() {return _navigateToToDoDetail}

    private val _navigateToToDoList = MutableLiveData<Boolean>()
    val navigateToToDoList : LiveData<Boolean>
        get() {return _navigateToToDoList}

    var user = MutableLiveData<User>()


    init {
        _navigateToToDoDetail.value = false
        _navigateToUserDetail.value = false
        _navigateToToDoList.value = false
    }


    fun btnNavigateToUserClicked() {
        _navigateToUserDetail.value = true
    }

    fun navigateToUserFinished() {
        _navigateToUserDetail.value = false
    }

    fun btnNavigateToToDoDetailClicked() {
        _navigateToToDoDetail.value = true
    }

    fun navigateToToDoDetailFinished() {
        _navigateToToDoDetail.value = false
    }

    fun btnNavigateToToDoListClicked() {
        _navigateToToDoList.value = true
    }

    fun navigateToToDoListFinished() {
        _navigateToToDoList.value = false
    }

}