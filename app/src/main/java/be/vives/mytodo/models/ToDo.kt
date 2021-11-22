package be.vives.mytodo.models

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
data class ToDo(var number: Int, var title: String, var description: String, var createdByUser: User, var createOnDate: Date, var assignedToUser: User?, var finishedOnDate: Date?, var toDotime: Long?, var remark: String?) : Parcelable {
    companion object {
        const val NEW = 0
        const val ASSIGNED = 1
        const val FINISHED = 2
    }

    @IgnoredOnParcel //avoid warning: Property would not be serialize into a Parcel in Kotlin
    var status = NEW
    get() {
        if (assignedToUser != null && finishedOnDate != null) {
            return FINISHED
        } else if (assignedToUser != null) {
            return ASSIGNED
        } else {
            return NEW
        }
    }
}
