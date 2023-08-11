package solid.icon.testtask.data

object Constants {
    const val PREFERENCE_NAME = "user_preference"
    fun getStateKey(position: Int): String = "user_$position"
}