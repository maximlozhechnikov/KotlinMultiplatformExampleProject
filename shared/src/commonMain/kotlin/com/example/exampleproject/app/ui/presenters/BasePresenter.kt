package com.example.exampleproject.app.ui.presenters

import com.example.exampleproject.app.ui.views.BaseView
import com.example.exampleproject.domain.Injector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext
import java.lang.Class

abstract class BasePresenter<View : BaseView>(protected val view: View, injector: Injector) :
    CoroutineScope,
    Injector by injector {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

}