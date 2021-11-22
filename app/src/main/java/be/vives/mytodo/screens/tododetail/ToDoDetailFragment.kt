package be.vives.mytodo.screens.tododetail


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import be.vives.mytodo.*
import be.vives.mytodo.databinding.FragmentToDoDetailBinding
import be.vives.mytodo.models.ToDo
import be.vives.mytodo.models.User
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ToDoDetailFragment : Fragment() {
    private lateinit var toDoDetailModel: ToDoDetailModel
    private lateinit var toDoDetailModelFactory: ToDoDetailModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentToDoDetailBinding>(inflater,
            R.layout.fragment_to_do_detail, container, false)
        val args  = ToDoDetailFragmentArgs.fromBundle(arguments!!)
        //Log.d("Debug", args.toDoList[0].description)
        toDoDetailModelFactory = ToDoDetailModelFactory(args.toDo)
        toDoDetailModel = ViewModelProviders.of(this, toDoDetailModelFactory).get(ToDoDetailModel::class.java)
        binding.data = toDoDetailModel
        //binding.tvToDoNumber.text = toDoDetailModel.toDo.value!!.number.toString()
        //return inflater.inflate(R.layout.fragment_to_do_detail, container, false)

        return binding.root

    }


}
