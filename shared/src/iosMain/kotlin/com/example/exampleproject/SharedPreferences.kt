package com.example.exampleproject

actual typealias SharedPrefs = NSObject

actual fun SharedPrefs.getInt(key: String): Int = NSUserDefaults
    .standartUserDefaults
    .integerForKey(key)
    .toInt()

actual fun SharedPrefs.setInt(key:String, value: Int) {
    NSUserDefaults
        .standartUserDefaults
        .setInteger(value.toLong(), key)
}

actual fun SharedPrefs.getString(key: String): String =
    NSUserDefaults
        .standartUserDefaults
        .StringForKey(key)

actual fun SharedPrefs.setString(key: String, value: String) {
    NSUserDefaults
        .standartUserDefaults
        .setString(value, key)
}