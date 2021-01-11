package com.example.kmmsimple.shared.iviapi.pages

import com.example.kmmsimple.shared.RocketLaunch
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class PagesApi(val httpClient: HttpClient) {

    suspend fun getPages(
        pageType: Int = 1,
        width: Int = 7,
        appVersion: Int = 2682,
        session: String = "e4de051e7720560751130600_1625813550-0PymP-hUOmosc0BNppl08-w"
    ): PagesAnswer {

        return httpClient.get(
            "https://api.ivi.ru/mobileapi/pages/v5/?" +
                    "width=$width" +
                    "&id=$pageType" +
                    "&app_version=$appVersion" +
                    "&session=$session"
        )
    }
}