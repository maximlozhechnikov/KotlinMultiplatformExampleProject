package com.example.exampleproject.data.providers

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual object HttpClientEngineProvider {

    actual val httpEngine: HttpClientEngine = Android.create()

}