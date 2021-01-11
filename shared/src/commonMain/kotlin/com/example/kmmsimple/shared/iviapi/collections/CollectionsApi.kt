package com.example.kmmsimple.shared.iviapi.collections

import com.example.kmmsimple.shared.iviapi.pages.Block
import com.example.kmmsimple.shared.iviapi.pages.PagesAnswer
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class CollectionsApi(val httpClient: HttpClient) {

    suspend fun getCollection(
        appVersion: Int = 2682,
        session: String = "e4de051e7720560751130600_1625813550-0PymP-hUOmosc0BNppl08-w",
        params: Block
    ): CatalogAnswer {

        val base = "https://api.ivi.ru/mobileapi/collection/catalog/v5/?" +
                (params.requestParams?.map { "${it.key}=${it.value}&" }?.joinToString("") ?: "")

        return httpClient.get(
            base +
                    "&app_version=$appVersion" +
                    "&session=$session"
        )
    }
}