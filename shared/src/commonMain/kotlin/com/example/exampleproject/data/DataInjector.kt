package com.example.exampleproject.data

import com.example.exampleproject.ContextProvider
import com.example.exampleproject.SharedPrefs
import com.example.exampleproject.app.remote.VkHttpClient
import com.example.exampleproject.data.sources.remote.VkRemoteRepository
import com.example.exampleproject.data.storages.DataProfileStorage
import com.example.exampleproject.dispatcher
import com.example.exampleproject.domain.Injector
import com.example.exampleproject.domain.repositories.VkRepository
import com.example.exampleproject.domain.storages.ProfileStorage
import com.petersamokhin.vksdk.core.client.VkApiClient
import com.petersamokhin.vksdk.core.model.VkSettings
import io.ktor.util.date.*
import kotlinx.serialization.json.Json

class DataInjector(private val context: ContextProvider): Injector {

    private val json = Json { encodeDefaults = false; ignoreUnknownKeys = true }

    override val profileStorage: ProfileStorage = DataProfileStorage(context as? SharedPrefs)


    override val vkRepository: VkRepository = VkRemoteRepository(json, profileStorage.token)



}