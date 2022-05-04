package com.example.exampleproject.data.sources.remote

import com.example.exampleproject.app.remote.VkHttpClient
import com.example.exampleproject.data.sources.remote.bodies.VkUserBody
import com.example.exampleproject.dispatcher
import com.example.exampleproject.domain.entities.VkUser
import com.example.exampleproject.domain.repositories.VkRepository
import com.example.exampleproject.domain.storages.ProfileStorage
import com.petersamokhin.vksdk.core.client.VkApiClient
import com.petersamokhin.vksdk.core.error.VkResponseException
import com.petersamokhin.vksdk.core.http.paramsOf
import com.petersamokhin.vksdk.core.model.VkResponseError
import com.petersamokhin.vksdk.core.model.VkResponseTypedSerializer
import com.petersamokhin.vksdk.core.model.VkSettings
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class VkRemoteRepository(private val json: Json, token: String?, private val profileStorage: ProfileStorage): VkRepository, ProfileStorage.TokenUpdateListener {

    private val vkHttpClient = VkHttpClient(dispatcher)
    private var vkApi: VkApiClient? = token?.let(::createVkApi)

    init {
        profileStorage.setupTokenUpdateListener(this)
    }
    @ExperimentalSerializationApi
    override suspend fun getCurrentUserData(): VkUser? {
        return vkApi?.get("account.getProfileInfo")?.let {
            val response = json.decodeFromJsonElement(
                VkResponseTypedSerializer(VkUserBody.serializer()),
                it
            )
            response.error?.let { throw VkResponseException() }
            response.response
        }
    }

    private fun createVkApi(token: String): VkApiClient = VkApiClient(
        id = 8135391,
        token = token,
        type = VkApiClient.Type.Community,
        settings = VkSettings (
            vkHttpClient,
            maxExecuteRequestsPerSecond = 3,
            backgroundDispatcher = dispatcher
        )
    )

    override fun onTokenUpdate(token: String) {
        vkApi = createVkApi(token)
    }
}