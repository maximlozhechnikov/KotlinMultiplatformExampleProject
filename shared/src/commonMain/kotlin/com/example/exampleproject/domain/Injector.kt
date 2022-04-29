package com.example.exampleproject.domain

import com.example.exampleproject.domain.repositories.VkRepository
import com.example.exampleproject.domain.storages.ProfileStorage

interface Injector {

    val profileStorage: ProfileStorage

    val vkRepository: VkRepository

}