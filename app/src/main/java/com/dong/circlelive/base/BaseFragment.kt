package com.dong.circlelive.base

import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * Create by dooze on 2021/5/9  3:48 下午
 * Email: dooze@sunday37.com
 * Description:
 */
abstract class BaseFragment : Fragment(), BaseView {
    override val mainScope: CoroutineScope by lazyFast {
        CoroutineScope(Dispatchers.Main.immediate + SupervisorJob() + commonCoroutineExceptionHandler)
    }
}