package be.vives.mytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_to_do_list)

        val database = FirebaseDatabase.getInstance().reference

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
            database.child(title).setValue(todo)


        }
        //getdata from database
        var getdata = object: ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
               var sb = StringBuilder()
                for (i in snapshot.children){
                    var title = i.child("title").getValue()
                    var description = i.child("description").getValue()
                    var IsChecked = i.child("IsChecked").getValue()
                    sb.append("${i.key} $title $description $IsChecked")
                }
                adapter.notifyItemInserted(todoList.size-1)
                etTodo.setText(sb)
            }

        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
        }
    }
