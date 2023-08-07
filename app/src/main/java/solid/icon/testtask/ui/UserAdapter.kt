package solid.icon.testtask.ui

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import solid.icon.testtask.R
import solid.icon.testtask.data.OnItemClickListener
import solid.icon.testtask.data.User

class UserAdapter(
    private val itemClickListener: OnItemClickListener,
    private val sharedPreferences: SharedPreferences,
    private val users: List<User>
) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(user)
        }
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
        private val studentSwitch: SwitchCompat = itemView.findViewById(R.id.studentSwitch)

        fun bind(user: User) {
            nameTextView.text = user.name
            ageTextView.text = user.age.toString()
            studentSwitch.isChecked = user.isStudent

            studentSwitch.setOnCheckedChangeListener { _, isChecked ->
                saveUserState(adapterPosition, isChecked)
            }
        }
    }

    fun saveUserState(position: Int, isChecked: Boolean) {
        val sharedKey = MainActivity.getStateKey(position)
        sharedPreferences.edit()
            .putBoolean(sharedKey, isChecked)
            .apply()
    }
}