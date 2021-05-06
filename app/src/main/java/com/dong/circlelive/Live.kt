package com.dong.circlelive

import android.content.Context
import io.agora.rtc.IRtcEngineEventHandler
import io.agora.rtc.RtcEngine

/**
 * Create by dooze on 5/3/21  7:29 PM
 * Email: dooze@sunday37.com
 * Description:
 */
class Live {

    private fun init(appContext: Context) {
        RtcEngine.create(appContext, "54a844b9550a430abe6365e7ee1f5d6f", LiveEventHandler())

    }


    inner class LiveEventHandler : IRtcEngineEventHandler() {

    }

    companion object {
        private lateinit var live: Live
        fun init(context: Context) {
            if (::live.isInitialized) return
            live = Live()
            live.init(context)
        }
    }
}