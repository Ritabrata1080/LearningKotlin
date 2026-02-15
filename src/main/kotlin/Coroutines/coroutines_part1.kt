package Coroutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


suspend fun main() {
    GlobalScope.launch {
        println("Hello from thread ${Thread.currentThread().name}")
    }
    delay(5000)
    println("Hello from thread ${Thread.currentThread().name}")
}
