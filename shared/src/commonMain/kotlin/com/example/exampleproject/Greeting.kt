package com.example.exampleproject

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}