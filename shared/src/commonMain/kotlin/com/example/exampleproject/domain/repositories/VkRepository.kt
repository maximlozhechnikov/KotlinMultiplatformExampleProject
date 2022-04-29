package com.example.exampleproject.domain.repositories

import com.example.exampleproject.domain.entities.VkUser

interface VkRepository {

    suspend fun getCurrentUserData(): VkUser?

}