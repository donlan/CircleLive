package com.dong.circlelive

import android.app.Application
import cn.leancloud.AVOSCloud
import com.dong.circlelive.base.Timber
import com.dong.circlelive.base.lazyFast

/**
 * Create by dooze on 5/3/21  7:06 PM
 * Email: dooze@sunday37.com
 * Description:
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
        Timber.plant(Timber.DebugTree())
        IM.init(this)
        Live.init(this)
        // 提供 this、App ID、App Key、Server Host 作为参数
        // 注意这里千万不要调用 cn.leancloud.core.AVOSCloud 的 initialize 方法，否则会出现 NetworkOnMainThread 等错误。
        AVOSCloud.initialize(this, "bzfullqEzVbJrcPur7fflyAc-gzGzoHsz", "72dDxPXS4yh3aF8GMSEkf57G", "https://bzfullqe.lc-cn-n1-shared.com");
    }

    companion object {
        lateinit var app: App
    }
}

val appContext by lazyFast { App.app }