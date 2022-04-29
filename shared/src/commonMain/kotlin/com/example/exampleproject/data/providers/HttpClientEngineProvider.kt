package com.example.exampleproject.data.providers

import io.ktor.client.engine.*

expect object HttpClientEngineProvider {

    val httpEngine: HttpClientEngine

}