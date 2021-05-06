package com.dong.circlelive

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.pm.PackageManager


/**
 * Create by dooze on 5/3/21  7:35 PM
 * Email: dooze@sunday37.com
 * Description:
 */
fun getAppName(context: Context, pID: Int): String? {
    var processName: String? = null
    val l: List<*> = (context.getSystemService(ACTIVITY_SERVICE) as ActivityManager).runningAppProcesses
    val i = l.iterator()
    while (i.hasNext()) {
        val info = i.next() as RunningAppProcessInfo
        try {
            if (info.pid == pID) {
                processName = info.processName
                return processName
            }
        } catch (e: Exception) {
            // Log.d("Process", "Error>> :"+ e.toString());
        }
    }
    return processName
}