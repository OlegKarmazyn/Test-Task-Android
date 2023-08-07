package solid.icon.testtask.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, val age: Int, val isStudent: Boolean) : Parcelable