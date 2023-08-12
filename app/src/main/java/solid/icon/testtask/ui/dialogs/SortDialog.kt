package solid.icon.testtask.ui.dialogs

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import solid.icon.testtask.R


//NOTE: dialog with one title and three buttons
class SortDialog(context: Context) : AppCompatDialog(context) {

    lateinit var tvTitle: TextView
    lateinit var tvSortByName: TextView
    lateinit var tvSortByAge: TextView
    lateinit var tvSortByStatus: TextView

    var byNameButtonListener: View.OnClickListener? = null
    var byAgeButtonListener: View.OnClickListener? = null
    var byStatusButtonListener: View.OnClickListener? = null

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.sort_dialog)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvTitle = findViewById(R.id.tvTitle)!!
        tvSortByName = findViewById(R.id.tvSortByName)!!
        tvSortByAge = findViewById(R.id.tvSortByAge)!!
        tvSortByStatus = findViewById(R.id.tvSortByStatus)!!

        tvSortByName.setOnClickListener {
            dismiss()
            byNameButtonListener?.onClick(it)
        }

        tvSortByAge.setOnClickListener {
            dismiss()
            byAgeButtonListener?.onClick(it)
        }

        tvSortByStatus.setOnClickListener {
            dismiss()
            byStatusButtonListener?.onClick(it)
        }
    }

    fun setSortByNameButton(listener: View.OnClickListener?) {
        byNameButtonListener = listener
    }

    fun setSortByAgeButton(listener: View.OnClickListener?) {
        byAgeButtonListener = listener
    }

    fun setSortByStatusButton(listener: View.OnClickListener?) {
        byStatusButtonListener = listener
    }
}