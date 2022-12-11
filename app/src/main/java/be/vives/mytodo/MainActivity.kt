package be.vives.mytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Delhaize","Ei" ,false),
            Todo("Aldi","Melk" ,false),
        )

        val adapter = TodoAdapter(todoList)
        var rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)


        var btnAddTodo = findViewById<Button>(R.id.btnAddToDo)
        var etTodo = findViewById<EditText>(R.id.etTodo)
        var etTodoDescription = findViewById<EditText>(R.id.etTodoDescription)
        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val description = etTodoDescription.text.toString()

            val todo = Todo(title, description,false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
            etTodo.setText("")
        }

    }
}