package com.example.exampleproject.data.sources.remote.bodies

import com.example.exampleproject.domain.entities.VkUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VkUserBody(
    @SerialName("first_name")
    override val firstName: String,
    @SerialName("last_name")
    override val lastName: String
) : VkUser
