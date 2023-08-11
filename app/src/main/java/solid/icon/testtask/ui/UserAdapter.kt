package solid.icon.testtask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import solid.icon.testtask.R
import solid.icon.testtask.data.database.User
import solid.icon.testtask.data.interfaces.OnItemClickListener

class UserAdapter(
    private val itemClickListener: OnItemClickListener,
    var userList: List<User>
) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(user)
        }
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
        private val studentSwitch: SwitchCompat = itemView.findViewById(R.id.studentSwitch)

        fun bind(user: User) {
            nameTextView.text = user.name
            ageTextView.text = user.age.toString()
            studentSwitch.isChecked = user.isStudent

            studentSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (user.isStudent != isChecked)
                    updateUserState(user, isChecked)
            }
        }
    }

    fun updateUserState(user: User, isChecked: Boolean) {
        user.isStudent = isChecked
        itemClickListener.updateUserState(user)
    }
}