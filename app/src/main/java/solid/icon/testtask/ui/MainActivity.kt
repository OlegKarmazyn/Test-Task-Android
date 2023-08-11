package solid.icon.testtask.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.dmoral.toasty.Toasty
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import solid.icon.testtask.R
import solid.icon.testtask.data.database.User
import solid.icon.testtask.data.interfaces.OnItemClickListener
import solid.icon.testtask.data.repository.MainViewModel

class MainActivity : AppCompatActivity(), KodeinAware, OnItemClickListener {

    override val kodein by kodein()

    private val viewModel: MainViewModel by instance()

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUI()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpUI() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter(this, emptyList())
        recyclerView.adapter = userAdapter

        viewModel.userList.observe(this) {
            userAdapter.userList = it
            userAdapter.notifyDataSetChanged()
        }
    }

    //region delegate OnItemClickListener
    override fun onItemClick(user: User) {
        val userDetailsFragment = UserDetailsFragment.newInstance(user)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, userDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onUserAdd(user: User?) {
        if (user != null) {
            viewModel.insertUser(user)
            Toasty.success(this, "User added successfully").show()
        } else
            Toasty.error(this, "Fill all fields").show()
    }

    override fun updateUserState(user: User) {
        viewModel.changeUserState(user)
    }
    //endregion

    private fun openAddingComponent() {
        val userInputFragment = UserInputFragment(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, userInputFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addUser -> openAddingComponent()
        }
        return super.onOptionsItemSelected(item)
    }
}