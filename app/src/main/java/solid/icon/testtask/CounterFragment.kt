package solid.icon.testtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class CounterFragment : Fragment() {

    private var clickCount = 0
    private val clickText: String
        get() = "Clicks: $clickCount"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_counter, container, false)

        val clickCounterTextView = view.findViewById<TextView>(R.id.clickCounterTextView)
        val fragmentButton = view.findViewById<Button>(R.id.fragmentButton)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            goBackToActivity()
        }

        fragmentButton.setOnClickListener {
            clickCount++
            clickCounterTextView.text = clickText
        }

        return view
    }

    private fun goBackToActivity() {
        val parentActivity = activity as? MainActivity
        parentActivity?.updateActivityClickCount(clickCount)
        parentFragmentManager.popBackStack()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CLICK_COUNT, clickCount)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState?.let {
            clickCount = it.getInt(KEY_CLICK_COUNT, 0)
            updateClickCountText()
        }
    }

    private fun updateClickCountText() {
        val clickCounterTextView = requireView().findViewById<TextView>(R.id.clickCounterTextView)
        clickCounterTextView.text = clickText
    }

    companion object {
        private const val KEY_CLICK_COUNT = "click_count"
    }
}
