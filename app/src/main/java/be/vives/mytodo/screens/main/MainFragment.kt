package be.vives.mytodo.screens.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import be.vives.mytodo.R
import be.vives.mytodo.UserSingelton
import be.vives.mytodo.databinding.FragmentMainBinding
import be.vives.mytodo.models.ToDo
import be.vives.mytodo.models.User
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private val user1 = User(2, "DirkHostens","Dirk", "Hostens", "password", true)
    private val user2 = User(1, "FrankDebaere","Frank", "Debaere", "password", true)
    private val toDo = ToDo(
        1,
        "Afwerken detailscherm ToDo",
        "Afwerken van detailscherm ToDo inclusief LiveData, ModelView en Databinding",
        user2,
        Date(),
        user1,
        Date(),
        2000L,
        "Geen opmerkingen"
    )
    private val toDo2 = ToDo(
        2,
        "Afwerken detailscherm ToDo",
        "Afwerken van detailscherm ToDo inclusief LiveData, ModelView en Databinding",
        user2,
        Date(),
        null,
        null,
        null,
        null
    )
    private val toDo3 = ToDo(
        3,
        "Afwerken detailscherm ToDo",
        "Afwerken van detailscherm ToDo inclusief LiveData, ModelView en Databinding",
        user2,
        Date(),
        user1,
        null,
        null,
        null
    )
    private val toDos :Array<ToDo> = arrayOf(toDo,toDo2, toDo3)

    private lateinit var mainModel: MainModel
    private lateinit var mainModelFactory: MainModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main, container, false)
        //setContentView(R.layout.activity_main)

        mainModelFactory = MainModelFactory()
        mainModel  = ViewModelProviders.of(this, mainModelFactory).get(MainModel::class.java)

        binding.mainModel = mainModel
        mainModel.navigateToToDoDetail.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

        })
        mainModel.navigateToUserDetail.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                navigateToUserDetail()
            }
        })
        mainModel.navigateToToDoDetail.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                navigateToToDoDetail()

            }
        })

        mainModel.navigateToToDoList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                navigateToToDoList()
            }
        })
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        //var user = GlobalApplication.applicationContext().user
        mainModel.user.value = UserSingelton.instance().user

    }

    private fun navigateToToDoDetail(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToToDoDetailFragment(toDo))
        mainModel.navigateToToDoDetailFinished()
    }

    private fun navigateToUserDetail(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToUserActivity())
        mainModel.navigateToUserFinished()
    }

    private fun navigateToToDoList(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToToDoListFragment())
        mainModel.navigateToToDoListFinished()
    }

}
