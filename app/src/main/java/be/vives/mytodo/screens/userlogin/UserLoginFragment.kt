package be.vives.mytodo.screens.userlogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import be.vives.mytodo.R
import be.vives.mytodo.UserActivity
import be.vives.mytodo.UserSingelton
import be.vives.mytodo.databinding.FragmentUserLoginBinding


class UserLoginFragment : Fragment() {

    private lateinit var binding: FragmentUserLoginBinding
    private lateinit var viewModel: UserLoginModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_login, container, false)
        viewModel = ViewModelProviders.of(this).get(UserLoginModel::class.java)
        binding.viewModel = viewModel
        viewModel.loginError.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.etLogin.setError(it)
            }
        })
        viewModel.errorPassword.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.etPassword.setError(it)
            }
        })
        viewModel.user.observe(viewLifecycleOwner, Observer {
            it?.let {
                //(activity as UserActivity).setCurrentUser(it)
                UserSingelton.instance().user = it
                requireView().findNavController().navigate(UserLoginFragmentDirections.actionUserLoginFragmentToUserDetailFragment())
            }
        })
        viewModel.navigateBack.observe(viewLifecycleOwner, Observer {
            if (it) {
                (activity as UserActivity).closeActivity()
            }

        })
        return binding.root
    }


}