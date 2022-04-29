package com.example.exampleproject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlin.coroutines.CoroutineContext

internal actual val dispatcher: CoroutineDispatcher = NsQueueDispatcher

private object NsQueueDispatcher : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue(), block::run)
    }

}