package com.example.exampleproject

expect class SharedPrefs

expect fun SharedPrefs.getInt(key: String): Int
expect fun SharedPrefs.setInt(key: String, value: Int)

expect fun SharedPrefs.getString(key: String): String
expect fun SharedPrefs.setString(key: String, value: String)