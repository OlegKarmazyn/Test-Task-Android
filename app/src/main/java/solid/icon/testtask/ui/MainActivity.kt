package solid.icon.testtask.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import solid.icon.testtask.R
import solid.icon.testtask.data.OnItemClickListener
import solid.icon.testtask.data.User

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val sharedPreferences by lazy {
        applicationContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val users = getHardcodedUsers()
        userAdapter = UserAdapter(this, sharedPreferences, users)
        recyclerView.adapter = userAdapter
    }

    override fun onItemClick(user: User) {
        val userDetailsFragment = UserDetailsFragment.newInstance(user)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, userDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getHardcodedUsers(): List<User> {
        val users = mutableListOf<User>()
        for (i in 0..6) {
            users.add(
                User(
                    name = "User $i",
                    age = 20 + i,
                    isStudent = getStateFromPreferences(i)
                )
            )
        }
        return users
    }

    private fun getStateFromPreferences(position: Int): Boolean =
        sharedPreferences.getBoolean(getStateKey(position), false)

    companion object {
        const val preferenceName = "user_prefs"
        fun getStateKey(position: Int): String = "user_$position"
    }
}