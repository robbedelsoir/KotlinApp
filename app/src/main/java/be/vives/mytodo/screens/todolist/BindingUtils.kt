package be.vives.mytodo.screens.todolist


import android.widget.TextView
import androidx.databinding.BindingAdapter
import be.vives.mytodo.R
import be.vives.mytodo.models.ToDo


@BindingAdapter("creatorOrAssignedUser")
fun TextView.setCreatorOrAssignedUser(item: ToDo) {
    var result:String
    if (item.status == ToDo.NEW) {
        result = resources.getString(R.string.createdUserString,item.createdByUser.firstName, item.createdByUser.lastName)
    } else if (item.status == ToDo.ASSIGNED) {
        result = resources.getString(R.string.assignedUserString,item.assignedToUser!!.firstName, item.assignedToUser!!.lastName)
    } else {
        result = resources.getString(R.string.finishedByUserString,item.assignedToUser!!.firstName, item.assignedToUser!!.lastName)
    }
    text = result
}

@BindingAdapter("status")
fun TextView.setStatus(item:ToDo) {
    var result: String
    when (item.status) {
        ToDo.NEW -> result =  "Nieuw"
        ToDo.ASSIGNED -> result = "Toegekend"
        else -> result = "Afgewerkt"
    }
    text = result
}