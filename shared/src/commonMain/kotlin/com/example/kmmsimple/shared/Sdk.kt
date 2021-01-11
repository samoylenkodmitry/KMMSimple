package com.example.kmmsimple.shared

import com.example.kmmsimple.shared.cache.Database
import com.example.kmmsimple.shared.cache.DatabaseDriverFactory
import com.example.kmmsimple.shared.iviapi.collections.CollectionsApi
import com.example.kmmsimple.shared.iviapi.pages.Block
import com.example.kmmsimple.shared.iviapi.pages.PagesAnswer
import com.example.kmmsimple.shared.iviapi.pages.PagesApi
import com.example.kmmsimple.shared.iviapi.pages.Type
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.ByteArraySerializer
import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf

@InternalSerializationApi
@ExperimentalSerializationApi
class Sdk(dbDriver: DatabaseDriverFactory) {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                isLenient = true
                encodeDefaults = true
                coerceInputValues = true

            }
            serializer = KotlinxSerializer(json)
        }
    }
    val db = Database(dbDriver)
    val api = Api(httpClient)
    val pagesApi = PagesApi(httpClient)
    val collectionsApi = CollectionsApi(httpClient)

    suspend fun getPagesFull(blockAtPositionUpdated: (Int) -> Unit): List<Block> {
        return pagesApi.getPages()
            .result?.blocks
            ?.filter { it.type == Type.Collection }
            ?.onEachIndexed { ind, block ->
                block.collection = collectionsApi.getCollection(params = block)
                blockAtPositionUpdated(ind)
            }?.also {
/*
                val data = it
                data.forEach { it.collection?.result?.forEach {
                    for (key in it.seasonsDescription.keys) {
                        if(it.seasonsDescription[key]==null)
                            it.seasonsDescription[key]=""
                    }
                    if (it.additionalData==null)it.additionalData= emptyList() }
                }

                val bytes = ProtoBuf.encodeToByteArray(data)
                println("xoxoxo0x "+it.size)
                println("xoxoxo0y "+bytes.size)
                val obj = ProtoBuf.decodeFromByteArray<List<Block>>(bytes)
                println("xoxoxo1 "+obj.size)
                val bytes2 = ProtoBuf.encodeToByteArray(obj)
                println("xoxoxo1y "+bytes2.size)
                val obj2 = ProtoBuf.decodeFromByteArray<List<Block>>(bytes2)
                println("xoxoxo12 "+obj2.size)
                println("xoxoxo check bytes")
                bytes.onEachIndexed { index, byte -> if(bytes2[index]!=byte) print("[index]")}
                println("xoxoxo check end")
*/


            } ?: emptyList()
    }

    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cached = db.getLaunches()
        if (cached.isNotEmpty() && !forceReload) {
            return cached
        }
        return api.getAll().also {
            db.clearDb()
            db.createLaunches(it)
        }
    }
}