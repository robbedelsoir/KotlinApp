package be.vives.mytodo.screens.todolist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager

import be.vives.mytodo.R
import be.vives.mytodo.databinding.FragmentToDoListBinding
import be.vives.mytodo.screens.main.MainFragmentDirections

/**
 * A simple [Fragment] subclass.
 */
class ToDoListFragment : Fragment() {
    private lateinit var toDoListViewModel: ToDoListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentToDoListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_list, container,false)

        val viewModelFactory = ToDoListModelFactory()
        toDoListViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(ToDoListModel::class.java)


        val adapter = ToDoListAdapter(ToDoClickListener {
            toDoListViewModel.onToDoClicked(it)
        })

        toDoListViewModel.toDoDetail.observe(viewLifecycleOwner, Observer { todo ->
            todo?.let {
                requireView().findNavController().navigate(ToDoListFragmentDirections.actionToDoListFragmentToToDoDetailFragment(todo))
                toDoListViewModel.onToDoDetailNavigated()
            }
        })
        binding.listTodo.adapter = adapter
        toDoListViewModel.toDoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        binding.setLifecycleOwner(this)
        val manager = LinearLayoutManager(activity)
        binding.listTodo.layoutManager = manager
        return binding.root
    }


}
