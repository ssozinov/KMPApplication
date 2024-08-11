package com.test.kmpapplication.platform

import app.cash.sqldelight.db.SqlDriver
import com.test.kmpapplication.Database

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database {
    val driver = driverFactory.createDriver()
    return Database(driver)
}