package be.vives.mytodo

data class Todo (
    val title: String,
    val description: String,
    var isChecked: Boolean
)