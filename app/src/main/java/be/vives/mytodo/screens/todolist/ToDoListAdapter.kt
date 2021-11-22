package be.vives.mytodo.screens.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import be.vives.mytodo.databinding.ToDoDetailItemInListBinding
import be.vives.mytodo.models.ToDo

class ToDoListAdapter(val clickListener: ToDoClickListener): ListAdapter<ToDo,ToDoListAdapter.ViewHolder>(ToDoDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: ToDoDetailItemInListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            toDo: ToDo,
            clickListener: ToDoClickListener
        ) {
            binding.todo = toDo
            binding.clicklistener = clickListener
            //itembinding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ToDoDetailItemInListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
class ToDoDiffCallback : DiffUtil.ItemCallback<ToDo>() {

    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        return oldItem == newItem
    }
}

class ToDoClickListener(val clickListener: (todo: ToDo) -> Unit) {
    fun onClick(todo: ToDo) = clickListener(todo)
}