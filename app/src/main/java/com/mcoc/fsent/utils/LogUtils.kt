package com.mcoc.fsent.utils

import com.facebook.stetho.common.LogUtil
import com.mcoc.fsent.utils.LogUtils

object LogUtils {
    private const val HEADER = "------------"
    @JvmStatic
    fun i(message: String) {
        LogUtil.i(HEADER + message)
    }

    fun d(message: String) {
        LogUtil.d(HEADER + message)
    }

    fun e(message: String) {
        LogUtil.e(HEADER + message)
    }

    fun v(message: String) {
        LogUtil.v(HEADER + message)
    }
}