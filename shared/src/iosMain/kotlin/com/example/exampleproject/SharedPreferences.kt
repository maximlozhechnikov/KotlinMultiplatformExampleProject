package com.example.exampleproject

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual typealias SharedPrefs = NSObject

actual fun SharedPrefs.getInt(key: String): Int = NSUserDefaults
    .standardUserDefaults
    .integerForKey(key)
    .toInt()

actual fun SharedPrefs.setInt(key:String, value: Int) {
    NSUserDefaults
        .standardUserDefaults
        .setInteger(value.toLong(), key)
}

actual fun SharedPrefs.getString(key: String): String =
    NSUserDefaults
        .standardUserDefaults
        .stringForKey(key) ?: ""

actual fun SharedPrefs.setString(key: String, value: String) {
    NSUserDefaults
        .standardUserDefaults
        .setString(value, key)
}