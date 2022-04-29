package com.example.exampleproject.android

import android.app.Application
import com.example.exampleproject.data.DataInjector

class ExampleProjectApplication: Application() {

    companion object {

        fun init(applicationContext: Application) {
            dataInjector = DataInjector(applicationContext)
        }

        var dataInjector: DataInjector? = null
    }


    override fun onCreate() {
        init(this)
        super.onCreate()
    }
}