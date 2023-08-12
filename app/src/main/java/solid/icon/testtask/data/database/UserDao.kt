package solid.icon.testtask.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User)

    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    @Delete
    suspend fun delete(user: User)
}