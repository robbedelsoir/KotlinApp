package be.vives.mytodo.screens.tododetail

import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.mytodo.models.ToDo
import java.text.SimpleDateFormat


class ToDoDetailModel(__toDo: ToDo) : ViewModel() {

    private val _toDo = MutableLiveData<ToDo>()
    val toDo : LiveData<ToDo>
        get() {return _toDo}

    val toDoStatus : String
        get() {
            when (_toDo.value!!.status) {
                ToDo.NEW -> return "Nieuw"
                ToDo.ASSIGNED -> return "Toegewezen"
                else -> return "Afgewerkt"
            }
        }
    val createDateString : String
        get(){
            val simpleDateFormat = SimpleDateFormat("dd-MMMM-yyyy")
            val date = simpleDateFormat.format(_toDo.value!!.createOnDate)
            return date
        }
    val finishedDateString : String
        get(){
            var date = ""
            if (_toDo.value!!.finishedOnDate != null) {
                val simpleDateFormat = SimpleDateFormat("dd-MMMM-yyyy")
                date = simpleDateFormat.format(_toDo.value!!.finishedOnDate!!)
            }
            return date
        }

    val toDoTimeString : String
        get() {
            var result  = "00:00"
            if (_toDo.value!!.toDotime != null) {
                result = DateUtils.formatElapsedTime(_toDo.value!!.toDotime!!)
            }
            return result
        }

    init {
        _toDo.value = __toDo

    }
}