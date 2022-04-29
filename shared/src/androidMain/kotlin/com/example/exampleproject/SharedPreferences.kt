package com.example.exampleproject

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

actual typealias SharedPrefs = Application

fun SharedPrefs.getSharedPreferences(): SharedPreferences =
    getSharedPreferences("", MODE_PRIVATE)

actual fun SharedPrefs.getInt(key: String) =
    getSharedPreferences()
        .getInt(key, -1)

actual fun SharedPrefs.setInt(key: String, value: Int) {
    getSharedPreferences()
        .edit()
        .putInt(key, value)
        .apply()
}

actual fun SharedPrefs.getString(key: String): String =
    getSharedPreferences()
        .getString(key, "") ?: ""

actual fun SharedPrefs.setString(key: String, value: String) =
    getSharedPreferences()
        .edit()
        .putString(key, value)
        .apply()