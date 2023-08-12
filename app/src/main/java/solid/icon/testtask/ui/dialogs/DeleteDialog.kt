package solid.icon.testtask.ui.dialogs

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import androidx.core.view.isVisible
import solid.icon.testtask.R


//NOTE: dialog with one title and two buttons
class DeleteDialog(context: Context) : AppCompatDialog(context) {

    lateinit var tvTitle: TextView
    lateinit var positiveButton: TextView
    lateinit var negativeButton: TextView

    var positiveButtonListener: View.OnClickListener? = null
    var negativeButtonListener: View.OnClickListener? = null

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.delete_dialog)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvTitle = findViewById(R.id.tvTitle)!!
        negativeButton = findViewById(R.id.tvNegative)!!
        positiveButton = findViewById(R.id.tvPositive)!!

        positiveButton.setOnClickListener {
            dismiss()
            positiveButtonListener?.onClick(it)
        }

        negativeButton.setOnClickListener {
            dismiss()
            negativeButtonListener?.onClick(it)
        }

        positiveButton.isVisible = false
        negativeButton.isVisible = false
    }

    fun setPositiveButton(textId: Int, listener: View.OnClickListener?) {
        positiveButton.run {
            text = context.getText(textId)
            isVisible = true
            positiveButtonListener = listener
        }
    }

    fun setNegativeButton(textId: Int, listener: View.OnClickListener?) {
        negativeButton.run {
            text = context.getText(textId)
            isVisible = true
            negativeButtonListener = listener
        }
    }
}