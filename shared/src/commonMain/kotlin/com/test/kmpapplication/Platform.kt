package com.test.kmpapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform