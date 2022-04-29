package com.example.exampleproject.android.activities

import android.content.Intent
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleproject.Screen
import com.example.exampleproject.android.ExampleProjectApplication
import com.example.exampleproject.app.ui.presenters.BasePresenter
import com.example.exampleproject.app.ui.views.BaseView
import com.example.exampleproject.domain.Injector

abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId), BaseView, Screen {

    protected abstract val presenter: BasePresenter<out BaseView>

    protected inline fun <reified P : BasePresenter<V>, reified V : BaseView> providePresenter(view: V): P =
        BasePresenter.createPresenter(
            P::class.java,
            view,
            ExampleProjectApplication.dataInjector!!,
            V::class.java,
            Injector::class.java
        )

    @Suppress("UNCHECKED_CAST")
    protected fun <T : View> bind(@IdRes resId: Int, initBlock: T.() -> Unit = {}): Lazy<T> = object : Lazy<T> {
        private var realValue: Any? = UNINITIALIZED_VLAUE
        private val initializer: (() -> T) = { findView(resId) }
        override val value: T
            get() {
                if (realValue === UNINITIALIZED_VLAUE) {
                    initializer().also { value ->
                        realValue = value
                        initBlock(value)
                    }
                }
                return realValue as T
            }

        override fun isInitialized(): Boolean = true

    }

    protected object UNINITIALIZED_VLAUE

    private fun <T : View> findView(id: Int): T = findViewById(id)

}