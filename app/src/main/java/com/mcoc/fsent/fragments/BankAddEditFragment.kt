package com.mcoc.fsent.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcoc.fsent.R

class BankAddEditFragment : Fragment() {

    companion object {
        fun newInstance() = BankAddEditFragment()
    }

    private lateinit var viewModel: BankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_edit_bank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BankViewModel::class.java)
        // TODO: Use the ViewModel
    }

}