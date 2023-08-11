package solid.icon.testtask.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import solid.icon.testtask.data.database.User

class MainViewModel(private val baseModel: BaseModel) : ViewModel() {

    val userList: LiveData<List<User>> = baseModel.getUsers()

    fun insertUser(user: User) {
        viewModelScope.launch { baseModel.upsert(user) }
    }

    fun changeUserState(user: User) {
        viewModelScope.launch { baseModel.upsert(user) }
    }
}