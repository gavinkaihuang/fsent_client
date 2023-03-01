package com.mcoc.fsent.fragments

import androidx.fragment.app.Fragment
import com.mcoc.fsent.Constant
import com.mcoc.fsent.utils.ToastUtils
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.json.JSONObject

open class BaseFragment: Fragment(), SingleObserver<JSONObject?> {


    open fun handleResult(result: JSONObject) {
        if (Constant.DEBUG)
            println(Constant.PRINT_HEADER + result.toString())
    }

    override fun onSubscribe(d: Disposable) {
//        TODO("Not yet implemented")
    }

    override fun onSuccess(t: JSONObject) {
        handleResult(t)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        ToastUtils.showToast(context, e.message)
    }


}