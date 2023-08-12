package solid.icon.testtask.data.repository

import solid.icon.testtask.data.database.AppDatabase
import solid.icon.testtask.data.database.User

class BaseModel(private val appDatabase: AppDatabase) {
    suspend fun upsert(user: User) = appDatabase.getUserDao().upsert(user)
    suspend fun delete(user: User) = appDatabase.getUserDao().delete(user)
    fun getUsers() = appDatabase.getUserDao().getUsers()
}