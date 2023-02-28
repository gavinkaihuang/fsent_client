package com.mcoc.fsent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mcoc.fsent.R
import com.mcoc.fsent.fragments.placeholder.BankPlaceholderContent
import com.mcoc.fsent.utils.MonthUtils
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

/**
 * A fragment representing a list of Items.
 */
class ConsumerItemListFragment : Fragment() {

    lateinit var promptView: TextView
    lateinit var calendarView: MaterialCalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_consumer_list, container, false)
        val listView = view.findViewById<RecyclerView>(R.id.list)
        // Set the adapter
        if (listView is RecyclerView) {
            with(listView) {
                layoutManager =  LinearLayoutManager(context)
                adapter = ConsumerItemRecyclerViewAdapter(BankPlaceholderContent.ITEMS)
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



}