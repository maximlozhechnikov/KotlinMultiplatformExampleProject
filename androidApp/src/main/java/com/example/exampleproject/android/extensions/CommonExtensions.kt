package com.example.exampleproject.android.extensions

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.exampleproject.app.ui.presenters.BasePresenter
import com.example.exampleproject.app.ui.views.BaseView
import com.example.exampleproject.domain.Injector
import java.io.File
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

inline fun <P : BasePresenter<V>, reified V : BaseView> createPresenter(
    clazz: Class<P>,
    view: V,
    injector: Injector,
): P = clazz.getDeclaredConstructor(V::class.java, Injector::class.java).newInstance(view, injector)

interface LoggingContext {
    val log: Logger // This context provides a reference to a logger
}

context(LoggingContext)
fun startBusinessOperation() {
    // You can access the log property since LoggingContext is an implicit receiver
    log.info("Operation has started")
}

fun test(loggingContext: LoggingContext) {
    with(loggingContext) {
        // You need to have LoggingContext in a scope as an implicit receiver
        // to call startBusinessOperation()
        startBusinessOperation()
    }
}