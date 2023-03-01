package com.mcoc.fsent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcoc.fsent.Constant
import com.mcoc.fsent.R
import com.mcoc.fsent.fragments.placeholder.BankPlaceholderContent
import com.mcoc.fsent.utils.LogUtils
import com.mcoc.fsent.utils.RX2AndroidNetworkingUtils
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.json.JSONException
import org.json.JSONObject


/**
 * A fragment representing a list of Items.
 */
class BankListFragment : Fragment(), SingleObserver<JSONObject?> {


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postRequest()
    }

    fun postRequest() {
        try {
            println("----------BANK_LIST:" + Constant.BANK_LIST)
            val jsonObject = JSONObject()
            RX2AndroidNetworkingUtils.postForData(Constant.BANK_LIST, jsonObject, this)
        } catch (e: JSONException) {
            e.message?.let { LogUtils.e(it) }
        }
    }

    fun handleResult(result: JSONObject) {
        println(result.toString())
    }

    override fun onSubscribe(d: Disposable) {
        println("----------onSubscribe")
    }

    override fun onSuccess(t: JSONObject) {
        println("----------onSuccess")
        handleResult(t)
    }

    override fun onError(e: Throwable) {
        println("----------onError")
        e.printStackTrace()
    }


}