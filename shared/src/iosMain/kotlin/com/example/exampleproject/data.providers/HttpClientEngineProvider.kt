package com.example.exampleproject.data.providers

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual object HttpClientEngineProvider {

    actual val httpEngine: HttpClientEngine = Ios.create()

}