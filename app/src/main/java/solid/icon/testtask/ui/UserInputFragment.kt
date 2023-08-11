package solid.icon.testtask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.Fragment
import solid.icon.testtask.R
import solid.icon.testtask.data.database.User
import solid.icon.testtask.data.interfaces.OnItemClickListener
import java.time.LocalDate

class UserInputFragment(private val onItemClickListener: OnItemClickListener) : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input_user, container, false)

        nameEditText = view.findViewById(R.id.nameEditText)
        ageEditText = view.findViewById(R.id.ageEditText)
        datePicker = view.findViewById(R.id.datePicker)
        saveButton = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            saveNewUser()
            closeFragment()
        }

        view.setOnClickListener {
            closeFragment()
        }

        return view
    }

    private fun saveNewUser() {
        val name = nameEditText.text.toString().trim()
        val ageText = ageEditText.text.toString().trim()

        val year = datePicker.year
        val month = datePicker.month
        val day = datePicker.dayOfMonth

        val selectedDate = LocalDate.of(year, month + 1, day)

        if (name.isNotBlank() && ageText.isNotBlank()) {
            onItemClickListener.onUserAdd(
                User(
                    name = name,
                    age = ageText.toInt(),
                    isStudent = false,
                    dateOfBirth = selectedDate
                )
            )
        } else {
            onItemClickListener.onUserAdd(null)
        }
    }

    private fun closeFragment(){
        activity?.supportFragmentManager?.popBackStack()
    }
}