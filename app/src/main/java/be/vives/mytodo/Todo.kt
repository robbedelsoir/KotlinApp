package be.vives.mytodo

import android.service.quicksettings.Tile
import java.lang.reflect.Constructor

class Todo (
    val title: String = "",
    val description: String = "",
    var isChecked: Boolean

)