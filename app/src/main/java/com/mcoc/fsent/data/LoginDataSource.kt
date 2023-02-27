package com.mcoc.fsent.data

import com.mcoc.fsent.Constant
import com.mcoc.fsent.data.model.LoggedInUser
import com.mcoc.fsent.utils.RX2AndroidNetworkingUtils.postForData
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.json.JSONObject
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource()  {


    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    fun loginAction(username: String, password: String, observer: SingleObserver<JSONObject?>) {
        val jsonParams = JSONObject()
        jsonParams.put("username", username)
        jsonParams.put("password", password)
        postForData(Constant.SIGN_IN, jsonParams, observer)

    }

}