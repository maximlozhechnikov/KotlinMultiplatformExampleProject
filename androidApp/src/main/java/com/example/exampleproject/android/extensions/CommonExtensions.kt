package com.example.exampleproject.android.extensions

import com.example.exampleproject.app.ui.presenters.BasePresenter
import com.example.exampleproject.app.ui.views.BaseView
import com.example.exampleproject.domain.Injector


inline fun <reified P : BasePresenter<V>, reified V : BaseView> createPresenter(
    clazz: Class<P>,
    view: V,
    injector: Injector,
): P = clazz.getDeclaredConstructor(V::class.java, Injector::class.java).newInstance(view, injector)