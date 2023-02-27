package com.mcoc.fsent.utils

import com.androidnetworking.interfaces.AnalyticsListener
import com.facebook.stetho.common.LogUtil
import com.mcoc.fsent.data.LoginDataSource
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

object RX2AndroidNetworkingUtils {
    fun getForData(url: String?, params: Map<String?, String?>?, observer: SingleObserver<JSONObject?>) {
        Rx2AndroidNetworking.get(url)
            .addPathParameter(params)
            .setUserAgent("getAnUser")
            .build()
            .setAnalyticsListener(object : AnalyticsListener {
                override fun onReceived(timeTakenInMillis: Long, bytesSent: Long, bytesReceived: Long, isFromCache: Boolean) {
                    LogUtils.i("timeTakenInMillis : $timeTakenInMillis")
                    LogUtil.i("bytesSent : $bytesSent")
                    LogUtil.i("bytesReceived : $bytesReceived")
                    LogUtil.i("isFromCache : $isFromCache")
                }
            })
            .getJSONObjectSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun postForData(url: String?, params: JSONObject?, observer: SingleObserver<JSONObject?>) {
        Rx2AndroidNetworking.post(url)
            .addJSONObjectBody(params)
            .setUserAgent("getAnUser")
            .build()
            .setAnalyticsListener(object : AnalyticsListener {
                override fun onReceived(timeTakenInMillis: Long, bytesSent: Long, bytesReceived: Long, isFromCache: Boolean) {
                    LogUtil.i("timeTakenInMillis : $timeTakenInMillis")
                    LogUtil.i("bytesSent : $bytesSent")
                    LogUtil.i("bytesReceived : $bytesReceived")
                    LogUtil.i("isFromCache : $isFromCache")
                }
            })
            .getJSONObjectSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    //                .getObjectSingle(User.class)
    //    public  static void testMathod() {
//    private val anUserDemo: Unit
//        private get() {
//            Rx2AndroidNetworking.get(ConstantData.HOME_IMGS)
//                .addPathParameter("userId", "1")
//                .setUserAgent("getAnUser")
//                .build()
//                .setAnalyticsListener(object : AnalyticsListener {
//                    override fun onReceived(timeTakenInMillis: Long, bytesSent: Long, bytesReceived: Long, isFromCache: Boolean) {
//                        LogUtil.i(" timeTakenInMillis : $timeTakenInMillis")
//                        LogUtil.i(" bytesSent : $bytesSent")
//                        LogUtil.i(" bytesReceived : $bytesReceived")
//                        LogUtil.i(" isFromCache : $isFromCache")
//                    }
//                }) //                .getObjectSingle(User.class)
//                .getJSONObjectSingle()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : SingleObserver<JSONObject?> {
//                    override fun onSubscribe(d: Disposable) {
//                        println("-------$d")
//                    }
//
//                    override fun onSuccess(jsonObject: JSONObject) {
//                        println("-------$jsonObject")
//                    }
//
//                    override fun onError(e: Throwable) {}
//                })
//        }
//
}