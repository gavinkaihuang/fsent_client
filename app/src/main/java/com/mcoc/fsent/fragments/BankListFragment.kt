package com.mcoc.fsent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcoc.fsent.R
import com.mcoc.fsent.fragments.placeholder.PlaceholderContent
import com.mcoc.fsent.utils.LogUtils
import com.mcoc.fsent.utils.MonthUtils
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

/**
 * A fragment representing a list of Items.
 */
class BankListFragment : Fragment() {

    private var columnCount = 1
    lateinit var promptView: TextView
    lateinit var calendarView: MaterialCalendarView

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bank_list, container, false)
        val listView = view.findViewById<RecyclerView>(R.id.list)
        // Set the adapter
        if (listView is RecyclerView) {
            with(listView) {
                layoutManager = LinearLayoutManager(context)
                adapter = BankItemRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }

        val lineView = view.findViewById<View>(R.id.line)
        calendarView = view.findViewById<MaterialCalendarView>(R.id.calendarView)
        promptView = view.findViewById<TextView>(R.id.exThreeSelectedDateText)
        val arrawView = view.findViewById<ImageView>(R.id.arrowIV)
        lineView.setOnClickListener(View.OnClickListener {
            if (calendarView.visibility != View.GONE) {
                calendarView.visibility = View.GONE
                arrawView.setImageResource(R.drawable.arraw_down)
            } else {
                calendarView.visibility = View.VISIBLE
                arrawView.setImageResource(R.drawable.arraw_up)
            }
        })

        initCurrentDate()

        return view
    }

    private fun initCurrentDate() {
        calendarView.apply {
            val day = CalendarDay.today()
            setCurrentDate(day)

//            LogUtils.v()
            val promptValue = MonthUtils.getMonthPrompt(day.month) + ", " + day.year
//            day.month + ", " + day.year
            promptView.text = promptValue
        }
    }




//    companion object {
//
//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//            BankListFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
//    }


}