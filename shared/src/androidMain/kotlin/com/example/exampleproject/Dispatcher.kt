package com.example.exampleproject

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val Dispatcher: CoroutineContext = Dispatchers.Main