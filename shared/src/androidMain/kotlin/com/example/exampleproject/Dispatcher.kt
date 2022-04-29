package com.example.exampleproject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val dispatcher: CoroutineDispatcher = Dispatchers.Main