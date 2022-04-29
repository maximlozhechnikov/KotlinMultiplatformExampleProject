package com.example.exampleproject.app.remote

import com.example.exampleproject.data.providers.HttpClientEngineProvider
import com.petersamokhin.vksdk.core.http.HttpClientConfig
import com.petersamokhin.vksdk.http.VkKtorHttpClient
import io.ktor.client.engine.*
import kotlin.coroutines.CoroutineContext

class VkHttpClient(override val coroutineContext: CoroutineContext): VkKtorHttpClient(coroutineContext) {

    override fun createEngineWithConfig(config: HttpClientConfig): HttpClientEngine? =
        HttpClientEngineProvider.httpEngine

}