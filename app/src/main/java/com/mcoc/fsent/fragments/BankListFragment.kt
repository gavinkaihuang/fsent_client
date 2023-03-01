package com.mcoc.fsent.fragments

import android.os.Bundle
import android.view.Gravity.apply
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.stetho.common.LogUtil
import com.mcoc.fsent.Constant
import com.mcoc.fsent.R
import com.mcoc.fsent.fragments.placeholder.BankHolder
import com.mcoc.fsent.fragments.placeholder.BankPlaceholderContent
import com.mcoc.fsent.utils.LogUtils
import com.mcoc.fsent.utils.RX2AndroidNetworkingUtils
import org.json.JSONException
import org.json.JSONObject


/**
 * A fragment representing a list of Items.
 */
class BankListFragment : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var adapter: BankItemRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bank_list, container, false)
        val listView = view.findViewById<RecyclerView>(R.id.list)
        listView.layoutManager = LinearLayoutManager(context)
        adapter = BankItemRecyclerViewAdapter()
        listView.adapter = adapter
//
//        // Set the adapter
//        if (listView is RecyclerView) {
//            with(listView) {
//                layoutManager = LinearLayoutManager(context)
//                adapter = BankItemRecyclerViewAdapter()
//            }
//        }
        listView.addItemDecoration(
            DividerItemDecoration(
                this.context,
                DividerItemDecoration.VERTICAL
            )
        )

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postRequest()
    }

    fun postRequest() {
        try {
            println(Constant.PRINT_HEADER + Constant.BANK_LIST)
            val jsonObject = JSONObject()
            RX2AndroidNetworkingUtils.postForData(Constant.BANK_LIST, jsonObject, this)
        } catch (e: JSONException) {
            e.message?.let { LogUtils.e(it) }
        }
    }

    //    var bankHolder: BankHolder
    override fun handleResult(result: JSONObject) {
        super.handleResult(result)
        val code = result.getString(Constant.CODE)
        if (code.equals(Constant.SUCCESS_CODE, ignoreCase = true)) {
            val jsonArray = result.getJSONArray(Constant.DATA)
            for (i in 0 until jsonArray.length()) {
                val jdata = jsonArray.getJSONObject(i)
                val item = BankHolder.BankItem(
                    jdata.getInt("id"),
                    jdata.getString("code") ?: "",
                    jdata.getString("bankname") ?: "",
                    jdata.getString("icon_url") ?: "",
                    jdata.getString("note") ?: "",
                )
                BankHolder.addItem(item)
            }
            adapter.setItemList(BankHolder.ITEMS)
            adapter.notifyDataSetChanged()
        }

    }

//    private override fun handleResult(result: JSONObject) {
//        try {
//            val code = result.getString(ConstantData.CODE)
//            if (code.equals(ConstantData.CODE_SUCCESS, ignoreCase = true)) {
//                val jsonArray = result.getJSONArray(ConstantData.DATA)
//                for (i in 0 until jsonArray.length()) {
//                    val jdata = jsonArray.getJSONObject(i)
//                    val placeholderItem = CartPlaceholderItem()
//                    placeholderItem.setCid(jdata.getString("cid"))
//                    placeholderItem.setPid(jdata.getString("pid"))
//                    placeholderItem.setFid(jdata.getString("fid"))
//                    placeholderItem.setName(jdata.getString("name"))
//                    placeholderItem.setPrice(jdata.getString("price"))
//                    placeholderItem.setNumber(jdata.getString("number"))
//                    placeholderItem.setImg(jdata.getString("img"))
//                    getPlaceholderContentInstant().addItem(placeholderItem)
//                }
//            } else {
//                val message = result.getString(ConstantData.MSG)
//                LogUtil.e("------------------$message")
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        //update userinterface
//        adapter.setItems(getPlaceholderContentInstant().ITEMS)
//        adapter.notifyDataSetChanged()
//        updatePageFooterHeight(binding.list)
//    }


}