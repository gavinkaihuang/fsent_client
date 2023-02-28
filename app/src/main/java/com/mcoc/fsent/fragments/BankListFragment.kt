package com.mcoc.fsent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcoc.fsent.R
import com.mcoc.fsent.fragments.placeholder.BankPlaceholderContent


/**
 * A fragment representing a list of Items.
 */
class BankListFragment : Fragment() {


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
                adapter = BankItemRecyclerViewAdapter(BankPlaceholderContent.ITEMS)
            }
        }
        listView.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

        return view
    }




}