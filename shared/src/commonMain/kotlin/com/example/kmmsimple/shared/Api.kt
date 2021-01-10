package com.example.kmmsimple.shared

import io.ktor.client.HttpClient
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class Api(val httpClient: HttpClient) {
    suspend fun getAll(): List<RocketLaunch>{
        return httpClient.get("https://api.spacexdata.com/v3/launches")
    }
}