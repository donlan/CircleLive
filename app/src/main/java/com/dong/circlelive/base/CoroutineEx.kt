package com.dong.circlelive.base

import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * Create by dooze on 2021/5/9  3:51 下午
 * Email: dooze@sunday37.com
 * Description:
 */
val commonCoroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
    Timber.e("Coroutine", exception) { "uncatch Coroutine exception" }
}

fun <T> lazyFast(operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, operation)