package be.vives.mytodo.screens.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.mytodo.models.User

class UserDetailModel(__user: User, __activeText:String, __notActiveText:String) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() {
            return _user
        }

    private val _activeText = MutableLiveData<String>()
    private val _notActiveText = MutableLiveData<String>()

    var userActiveText = MutableLiveData<String>()

    private var _navigateToOverview = MutableLiveData<Boolean>()
    val navigateToOverview : LiveData<Boolean>
    get() {
        return _navigateToOverview
    }
    /*
    //dit werkt niet omdat de tekst niet werd aangepast
    //nadat de toggle button (en dus de user.isActive) werd aangepast.
    //opgelost door een simpele MutableLiveData<String>() van te maken.
    var userActiveText : MutableLiveData<String>()
        get() {
            var text = _notActiveText
            if (_user.value!!.isActive) {
                text = _activeText
            }
            return text
        }
        set(value) {
            var text = _notActiveText
            if (_user.value!!.isActive) {
                text = _activeText
            }
            userActiveText = text
        }*/

    init {
        _user.value = __user
        _activeText.value = __activeText
        _notActiveText.value = __notActiveText
        userActiveText.value = getActiveText()
        _navigateToOverview.value = false
    }

    //called when switch clicked
    fun onActiveChanged() {
        //change active text
        userActiveText.value = getActiveText()
    }

    fun btnToOverzichtClicked() {
        _navigateToOverview.value = true
    }

    private fun getActiveText(): String {
        var text = _notActiveText
        if (user.value!!.isActive) {
            text = _activeText
        }
        return text.value!!
    }


}