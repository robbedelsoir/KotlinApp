package be.vives.mytodo.screens.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.mytodo.models.ToDo
import be.vives.mytodo.screens.utils.MockupToDo

class ToDoListModel: ViewModel() {

    private val _toDoList = MockupToDo.getToDos()

    val toDoList: LiveData<List<ToDo>>
    get() {
        return _toDoList
    }
    private val _toDoToDetail = MutableLiveData<ToDo>()
    val toDoDetail
        get() = _toDoToDetail

    fun onToDoClicked(todo: ToDo){
        _toDoToDetail.value = todo
    }
    fun onToDoDetailNavigated() {
        _toDoToDetail.value = null
    }

    init {
        
    }
}
