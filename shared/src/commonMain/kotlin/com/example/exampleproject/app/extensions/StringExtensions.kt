package com.example.exampleproject.app.extensions

private const val SEPARATOR = "&"

fun String.query(key: String): String? {
    if (indexOf(key) == -1) return null
    if (substring(indexOf(key) + key.length + 1).isBlank()) return null
    if (substring(indexOf(key) + key.length + 1).indexOf(SEPARATOR) == -1) return null
    return substring(
        (indexOf(key) + key.length + 1),
        substring((indexOf(key) + key.length + 1)).indexOf(SEPARATOR) + (indexOf(key) + key.length + 1)
    )
}
