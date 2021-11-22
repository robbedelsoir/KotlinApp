package be.vives.mytodo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var id: Int, var userName: String,var firstName: String, var lastName: String, var password: String, var isActive: Boolean): Parcelable  {
}