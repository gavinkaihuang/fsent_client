package com.mcoc.fsent.utils

import com.facebook.stetho.common.LogUtil
import com.mcoc.fsent.utils.LogUtils

object LogUtils {
    private const val HEADER = "------------"
    @JvmStatic
    fun i(message: String) {
//        println("i>>>>>>" + HEADER + message)
        LogUtil.i(HEADER + message)
    }

    fun d(message: String) {
//        println("debug>>>>>>" + HEADER + message)
        LogUtil.d(HEADER + message)
    }

    fun e(message: String) {
//        println("error>>>>>>" + HEADER + message)
        LogUtil.e(HEADER + message)
    }

    fun v(message: String) {
//        println("v>>>>>>" + HEADER + message)
        LogUtil.v(HEADER + message)
    }
}