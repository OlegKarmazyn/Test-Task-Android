package solid.icon.testtask.data.interfaces

import solid.icon.testtask.data.database.User

interface OnItemClickListener {
    fun onItemClick(user: User)
    fun onUserAdd(user: User?)
    fun ondUserDelete(user: User)
    fun updateUserState(user: User)
}