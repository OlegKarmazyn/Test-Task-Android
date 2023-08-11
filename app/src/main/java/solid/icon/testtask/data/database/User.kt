package solid.icon.testtask.data.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Entity(tableName = "users")
@Parcelize
data class User(
    val name: String,
    val age: Int,
    var isStudent: Boolean,
    val dateOfBirth: LocalDate
) : Parcelable{
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}