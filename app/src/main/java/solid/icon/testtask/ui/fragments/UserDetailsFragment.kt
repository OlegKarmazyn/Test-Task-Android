package solid.icon.testtask.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import solid.icon.testtask.R
import solid.icon.testtask.data.database.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UserDetailsFragment : Fragment() {

    private lateinit var user: User

    companion object {
        private const val ARG_USER = "arg_user"

        fun newInstance(user: User): UserDetailsFragment {
            val fragment = UserDetailsFragment()
            val args = Bundle()
            args.putParcelable(ARG_USER, user)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getParcelable(ARG_USER)!!
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_details, container, false)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val ageTextView: TextView = view.findViewById(R.id.ageTextView)
        val studentTextView: TextView = view.findViewById(R.id.studentTextView)
        val birthTextView: TextView = view.findViewById(R.id.birthTextView)

        nameTextView.text = user.name
        ageTextView.text = user.age.toString()
        studentTextView.text = if (user.isStudent) "Yes" else "No"
        birthTextView.text = getBirthText(user.dateOfBirth)

        view.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }

    private fun getBirthText(dateOfBirth: LocalDate) : String{
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }
}