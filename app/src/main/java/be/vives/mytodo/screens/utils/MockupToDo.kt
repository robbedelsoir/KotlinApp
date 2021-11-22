package be.vives.mytodo.screens.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import be.vives.mytodo.models.ToDo
import be.vives.mytodo.models.User
import java.util.*

class MockupToDo {


    /*val cal1 = Calendar.getInstance()
    cal1.set(Calendar.YEAR, 2021)
    cal1.set(Calendar.MONTH, 10)
    cal1.set(Calendar.DAY_OF_MONTH,23)
    val cal2 = Calendar.getInstance()
    cal2.set(Calendar.YEAR, 2021)
    cal2.set(Calendar.MONTH, 11)
    cal2.set(Calendar.DAY_OF_MONTH,23)
    var toDoObject = ToDo(1,"Afwerken detailscherm ToDO", "Afwerken van detailscherm ToDo incl LiveData, ModelView en Databinding", user1, cal1.time, user2, cal2.time, 4335, "Geen opmerkingen")


     */
    companion object {
        private val assignedUser = User(2, "DirkHostens","Dirk", "Hostens", "password", true)
        private val createduser = User(1, "FrankDebaere","Frank", "Debaere", "password", true)

        private val toDo = ToDo(
            1,
            "Afwerken detailscherm ToDo",
            "Afwerken van detailscherm ToDo inclusief LiveData, ModelView en Databinding",
            createduser,
            Date(),
            assignedUser,
            Date(),
            2000L,
            "Geen opmerkingen"
        )
        private val toDo2 = ToDo(
            2,
            "Afwerken detailscherm ToDo",
            "Afwerken van detailscherm ToDo inclusief LiveData, ModelView en Databinding",
            createduser,
            Date(),
            null,
            null,
            null,
            null
        )
        private val toDo3 = ToDo(
            3,
            "Afwerken detailscherm ToDo",
            "Afwerken van detailscherm ToDo inclusief LiveData, ModelView en Databinding",
            createduser,
            Date(),
            assignedUser,
            null,
            null,
            null
        )
        private val toDos :Array<ToDo> = arrayOf(toDo,toDo2, toDo3)

        fun getToDos(): LiveData<List<ToDo>> {
            var toDoList = MutableLiveData<List<ToDo>>()
            toDoList.value = toDos.toList()
            return toDoList
        }
    }
}