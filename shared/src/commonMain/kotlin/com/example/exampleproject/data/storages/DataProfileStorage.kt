package com.example.exampleproject.data.storages

import com.example.exampleproject.*
import com.example.exampleproject.domain.storages.ProfileStorage
import com.example.exampleproject.domain.storages.ProfileStorage.TokenUpdateListener

class DataProfileStorage(private val context: SharedPrefs?) : ProfileStorage {

    private companion object {
        private const val KEY_TOKEN = "rocken"
        private const val KEY_EXPIRES = "expires"
    }

    override var tokenUpdateListener: TokenUpdateListener? = null
    override var token: String?
        get() = context?.getString(KEY_TOKEN)
        set(value) {
            value?.let { tokenUpdateListener?.onTokenUpdate(it) }
            context?.setString(KEY_TOKEN, value ?: "")
        }
    override var expiresDateInTimestamp: Long?
        get() = context?.getInt(KEY_EXPIRES)?.toLong()
        set(value) {
            context?.setInt(KEY_EXPIRES, value?.toInt() ?: 0)
        }

    override fun setupTokenUpdateListener(tokenUpdateListener: TokenUpdateListener) {
        this.tokenUpdateListener = tokenUpdateListener
    }

}