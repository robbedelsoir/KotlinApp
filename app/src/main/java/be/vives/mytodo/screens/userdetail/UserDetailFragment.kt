package be.vives.mytodo.screens.userdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import be.vives.mytodo.R
import be.vives.mytodo.UserActivity
import be.vives.mytodo.UserSingelton
import be.vives.mytodo.models.User
import be.vives.mytodo.databinding.FragmentUserDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class UserDetailFragment : Fragment() {


    //private lateinit var viewUserActivity : ViewUserActivity
    private lateinit var userDetailModelFactory: UserDetailModelFactory
    private lateinit var userDetailModel: UserDetailModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentUserDetailBinding>(inflater,
            R.layout.fragment_user_detail,container, false)

        //val user = (activity as UserActivity).getCurrentUser()
        val user = UserSingelton.instance().user
        userDetailModelFactory = UserDetailModelFactory(
            user!!,
            resources.getString(R.string.userActive),
            resources.getString(R.string.userNotActive)
        )
        userDetailModel = ViewModelProviders.of(this, userDetailModelFactory).get(UserDetailModel::class.java)
        binding.myData = userDetailModel

        //make Fragment observer of the LiveData
        binding.lifecycleOwner = this


        /*val activeText: String = if (user.isActive) { resources.getString(R.string.userActive) } else { resources.getString(R.string.userNotActive)}

        viewUserActivity = ViewUserActivity(user.firstName, user.lastName, user.isActive, activeText )
        binding.myData = viewUserActivity

        binding.switchUserActive.setOnClickListener { view ->
            binding.apply {
                if (viewUserActivity.isActive) {
                    viewUserActivity.activeText = resources.getString(R.string.userActive)
                } else {
                    viewUserActivity.activeText = resources.getString(R.string.userNotActive)
                }
                invalidateAll()
            }
            user.isActive = viewUserActivity.isActive
        }

        */

        userDetailModel.navigateToOverview.observe(viewLifecycleOwner, Observer {
            if (it) {
                (activity as UserActivity).closeActivity()
            }
        })
        return binding.root

    }


}
