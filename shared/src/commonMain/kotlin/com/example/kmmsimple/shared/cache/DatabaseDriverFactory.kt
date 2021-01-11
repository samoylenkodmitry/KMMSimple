package com.example.kmmsimple.shared.cache

import com.squareup.sqldelight.db.SqlDriver


expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
