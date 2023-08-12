package solid.icon.testtask.data.repository

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import solid.icon.testtask.data.database.User

class MainViewModel(private val baseModel: BaseModel) : ViewModel() {

    val sortStatus: MutableLiveData<SortStatus> = MutableLiveData(SortStatus.SortByDefault)

    private val _userList: LiveData<List<User>> = baseModel.getUsers()

    val userList: LiveData<List<User>> = MediatorLiveData<List<User>>().apply {
        addSource(_userList) { originalList ->
            value = applySorting(originalList)
        }
        addSource(sortStatus) {
            _userList.value?.let { originalList ->
                value = applySorting(originalList)
            }
        }
    }

    fun insertUser(user: User) {
        viewModelScope.launch { baseModel.upsert(user) }
    }

    fun changeUserState(user: User) {
        viewModelScope.launch {
            println("user.isStudent - ${user.isStudent}")
            baseModel.upsert(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch { baseModel.delete(user) }
    }

    private fun applySorting(originalList: List<User>): List<User> {
        return when (sortStatus.value) {
            SortStatus.SortByName -> originalList.sortedBy { it.name }
            SortStatus.SortByAge -> originalList.sortedBy { it.age }
            SortStatus.SortByStatus -> originalList.sortedBy { !it.isStudent }
            else -> originalList.sortedBy { it.id }
        }
    }


    enum class SortStatus {
        SortByDefault,
        SortByName,
        SortByAge,
        SortByStatus
    }
}