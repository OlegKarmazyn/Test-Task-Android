package solid.icon.testtask.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import solid.icon.testtask.R
import solid.icon.testtask.data.User

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

        nameTextView.text = user.name
        ageTextView.text = user.age.toString()
        studentTextView.text = "Is Student: ${if (user.isStudent) "Yes" else "No"}"

        view.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }
}

