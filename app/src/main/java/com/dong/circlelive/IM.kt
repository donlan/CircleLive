package com.dong.circlelive

import android.content.Context
import android.os.Process
import com.hyphenate.chat.EMClient
import com.hyphenate.chat.EMOptions

/**
 * Create by dooze on 5/3/21  7:34 PM
 * Email: dooze@sunday37.com
 * Description:
 */
class IM {

    companion object {
        fun init(context: Context) {
            val pid = Process.myPid()
            val processAppName = getAppName(context, pid)
            if (processAppName == null || !processAppName.equals(context.packageName, ignoreCase = true)) {
                // 则此application::onCreate 是被service 调用的，直接返回
                return
            }

            val options = EMOptions()
            // 默认添加好友时，是不需要验证的，改成需要验证
            options.acceptInvitationAlways = false
            // 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
            options.autoTransferMessageAttachments = true
            // 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
            options.setAutoDownloadThumbnail(true)
            //初始化
            EMClient.getInstance().init(context, options)
            //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
            EMClient.getInstance().setDebugMode(true)
        }
    }
}