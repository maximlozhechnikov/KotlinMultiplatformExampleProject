package com.example.exampleproject.domain.storages

interface ProfileStorage {

    var tokenUpdateListener: TokenUpdateListener?
    var token: String?
    var expiresDateInTimestamp: Long?

    fun setupTokenUpdateListener(tokenUpdateListener: TokenUpdateListener)

    interface TokenUpdateListener {
        fun onTokenUpdate(token: String)
    }

}