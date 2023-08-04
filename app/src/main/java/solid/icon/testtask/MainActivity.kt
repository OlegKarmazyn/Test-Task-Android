package solid.icon.testtask

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityButton = findViewById<Button>(R.id.activityButton)
        activityButton.setOnClickListener {
            openFragment()
        }
    }

    private fun openFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, CounterFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

