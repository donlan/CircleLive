package com.dong.circlelive

import android.app.Application

/**
 * Create by dooze on 5/3/21  7:06 PM
 * Email: dooze@sunday37.com
 * Description:
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        IM.init(this)
        Live.init(this)
    }

}