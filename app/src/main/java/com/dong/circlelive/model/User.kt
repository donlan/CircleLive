package com.dong.circlelive.model

import cn.leancloud.AVException
import cn.leancloud.AVException.USERNAME_TAKEN
import cn.leancloud.AVUser
import com.dong.circlelive.Utils.md5
import com.dong.circlelive.emClient
import com.hyphenate.EMError
import com.hyphenate.exceptions.HyphenateException

/**
 * Create by dooze on 2021/5/12  9:39 下午
 * Email: dooze@sunday37.com
 * Description:
 */


var AVUser.emUsername: String
    get() = getString("emUsername")
    set(value) = put("emUsername", value)

fun createAVUser(username: String, password: String): AVUser {
    return AVUser().apply {
        this.username = username
        this.password = password
        this.emUsername = username.md5
    }
}

suspend fun AVUser.login(): AVUser {
    var signUp: Boolean
    val pwd = password
    try {
        signUp()
        signUp = true
        emClient.createAccount(emUsername, pwd)
    } catch (t: Throwable) {
        if (t is AVException && t.code == USERNAME_TAKEN || kotlin.run {
                val cause = t.cause
                cause is AVException && cause.code == USERNAME_TAKEN
            }) {
            signUp = true
        } else {
            throw t
        }
    }
    if (signUp) {
        AVUser.logIn(username, pwd).blockingFirst()
    }
    return AVUser.getCurrentUser()
}