package com.test.kmpapplication.platform

sealed class Failure(override val message: String) : Throwable() {
    class Http(val code: Int, override val message: String) : Failure(message)
    class Message(message: String) : Failure(message)
    object InternetConnection : Failure("No connections")

}