package com.mcoc.fsent.data

import com.facebook.stetho.common.LogUtil
import com.mcoc.fsent.data.model.LoggedInUser
import com.mcoc.fsent.utils.LogUtils
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.json.JSONObject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) : SingleObserver<JSONObject?> {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        loginAction(username, password)

        return result
    }

    fun loginAction(username: String, password: String) {
        dataSource.loginAction(username, password, this)
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    override fun onSubscribe(d: Disposable) {
        LogUtils.d(d.toString())
    }

    override fun onSuccess(t: JSONObject) {
        LogUtils.d(t.toString())
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is com.androidnetworking.error.ANError) {
            val errorCode = e.errorCode
            LogUtils.e("" + errorCode)
            val errorBody = e.errorBody
            LogUtils.e(errorBody)
            val errorDetail = e.errorDetail
            LogUtils.e(errorDetail)
        }
//        LogUtils.d(e.toString())
    }
}