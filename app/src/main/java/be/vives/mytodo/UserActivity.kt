package be.vives.mytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import be.vives.mytodo.databinding.ActivityUserBinding
import be.vives.mytodo.models.User

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        //setContentView(R.layout.activity_user)

        /*val args  = UserActivityArgs.fromBundle(intent.getExtras()!!)
        currentUser = args.user*/

    }


   /* fun getCurrentUser() : User {
        return currentUser
    }
    fun setCurrentUser(user:User) {
        currentUser = user
    }*/
    fun closeActivity() {
        finish()
    }
}
