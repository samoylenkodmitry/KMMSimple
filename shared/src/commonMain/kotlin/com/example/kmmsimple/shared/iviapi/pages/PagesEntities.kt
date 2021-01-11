// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json        = Json(JsonConfiguration.Stable)
// val pagesAnswer = json.parse(PagesAnswer.serializer(), jsonString)

package com.example.kmmsimple.shared.iviapi.pages

import com.example.kmmsimple.shared.iviapi.collections.CatalogAnswer
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

@Serializable
data class PagesAnswer (
    val result: Result? = null,

    @SerialName("session_data")
    val sessionData: String? = null
)

@Serializable
data class Result (
    val id: Long? = null,
    val title: String? = null,
    val limit: Long? = null,

    @SerialName("group_tab_id")
    val groupTabID: Long? = null,

    @SerialName("background_images")
    val backgroundImages: JsonArray? = null,

    val hru: String? = null,

    @SerialName("groot_params")
    val grootParams: GrootParams? = null,

    val blocks: List<Block>? = null,
    val tabs: JsonArray? = null
)

@Serializable
data class Block (
    val id: Long? = null,
    val type: Type? = null,
    val limit: Long? = null,

    @SerialName("groot_identifier")
    val grootIdentifier: UIID? = null,

    val version: Long? = null,

    @SerialName("groot_params")
    val grootParams: GrootParams? = null,

    @SerialName("request_params")
    val requestParams: MutableMap<String, String?>? = null,

    val title: String? = null,
    val hru: String? = null,

    var collection: CatalogAnswer? = CatalogAnswer()
)

@Serializable(with = UIID.Companion::class)
enum class UIID(val value: String) {
    Collection("collection"),
    Empty(""),
    MiniPromoList("mini_promo_list"),
    PromoList("promo_list"),
    Unknown("")
    ;

    companion object : KSerializer<UIID> {
        override val descriptor: SerialDescriptor get() {
            return PrimitiveSerialDescriptor("com.example.kmmsimple.shared.iviapi.pages.UIID", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): UIID = when (val value = decoder.decodeString()) {
            "collection"      -> Collection
            ""                -> Empty
            "mini_promo_list" -> MiniPromoList
            "promo_list"      -> PromoList
            else              -> Unknown
        }
        override fun serialize(encoder: Encoder, value: UIID) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable
data class GrootParams (
    @SerialName("ui_type")
    val uiType: UIID? = null,

    @SerialName("ui_id")
    val uiID: UIID? = null
)

@Serializable(with = Sort.Companion::class)
enum class Sort(val value: String) {
    Relevance("relevance"),
    Unknown("");

    companion object : KSerializer<Sort> {
        override val descriptor: SerialDescriptor get() {
            return PrimitiveSerialDescriptor("com.example.kmmsimple.shared.iviapi.pages.Sort", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): Sort = when (val value = decoder.decodeString()) {
            "relevance" -> Relevance
            else        -> Unknown
        }
        override fun serialize(encoder: Encoder, value: Sort) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable(with = Type.Companion::class)
enum class Type(val value: String) {
    Collection("collection"),
    FakeCollection("fake_collection"),
    Minipromo("minipromo"),
    Promo("promo"),
    Unknown("");

    companion object : KSerializer<Type> {
        override val descriptor: SerialDescriptor
            get() {
            return PrimitiveSerialDescriptor("com.example.kmmsimple.shared.iviapi.pages.Type", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): Type = when (val value = decoder.decodeString()) {
            "collection"      -> Collection
            "fake_collection" -> FakeCollection
            "minipromo"       -> Minipromo
            "promo"           -> Promo
            else              -> Unknown
        }
        override fun serialize(encoder: Encoder, value: Type) {
            return encoder.encodeString(value.value)
        }
    }
}
/*
{
  "result": {
    "id": 1,
    "title": "Мой ivi",
    "limit": 17,
    "group_tab_id": 1,
    "background_images": [],
    "hru": "",
    "groot_params": {
      "ui_id": "",
      "ui_type": ""
    },
    "blocks": [
      {
        "id": 1093,
        "type": "promo",
        "limit": 30,
        "groot_identifier": "promo_list",
        "version": 1,
        "groot_params": {
          "ui_type": "promo_list",
          "ui_id": "promo_list"
        },
        "request_params": {
          "site_section": 20,
          "withpreorderable": true
        }
      },
      {
        "id": 3,
        "type": "collection",
        "title": "Рекомендуем вам посмотреть",
        "hru": "rekomenduem-vam-posmotret",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 4655,
          "withpreorderable": true,
          "relevance_cookie": "4156220,4504830,2578540,4510560,2022550,2139870,2250500,2120150,102091,4143080,1589200,1726240,2061040,1336940,1235590,2509770,3156390,74851,1021920,1118470"
        }
      },
      {
        "id": 22,
        "type": "collection",
        "title": "Мультфильмы для всех возрастов",
        "hru": "multfilmyi_dlya_vseh",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 1205,
          "withpreorderable": true,
          "relevance_cookie": "2120150,1118470,102091,1589200,1779020,95791,1384490,92571,73121,967240,102751,124281,90921,999830,127041,72801,82951,124251,111501,963260"
        }
      },
      {
        "id": 153,
        "type": "collection",
        "title": "Лучшие драмы",
        "hru": "best-drama",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 925,
          "withpreorderable": true,
          "relevance_cookie": "1235590,4143080,1097260,2268710,1091930,590970,2087860,1033040,1384290,1056250,530160,999820,1123720,3489300,4205100,875100,1153610,2190450,978060,1740800"
        }
      },
      {
        "id": 4033,
        "type": "fake_collection",
        "title": "Скоро на ivi",
        "hru": "soon-ivi",
        "groot_identifier": "collection",
        "version": 3,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "id": 1986,
          "withpreorderable": true
        }
      },
      {
        "id": 6,
        "type": "minipromo",
        "title": "Самое интересное",
        "groot_identifier": "mini_promo_list",
        "version": 1,
        "groot_params": {
          "ui_type": "mini_promo_list",
          "ui_id": "mini_promo_list"
        },
        "request_params": {
          "site_section": 4,
          "withpreorderable": true
        }
      },
      {
        "id": 98,
        "type": "collection",
        "title": "Комедийные мелодрамы",
        "hru": "komedijnyie-melodramyi",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 1312,
          "withpreorderable": true,
          "relevance_cookie": "74851,1927110,4146550,71631,142411,78681,137031,1226020,3575310,1335170,4145090,82791,77011,1658490,1669510,1061970,529470,4148450,1034140,2142840"
        }
      },
      {
        "id": 97,
        "type": "collection",
        "title": "Кассовые фильмы",
        "hru": "cash-movies",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 3680,
          "withpreorderable": true,
          "relevance_cookie": "1726240,1322910,1336940,1384290,1123580,605520,1226020,1333050,1451460,875100,642470,1000080"
        }
      },
      {
        "id": 165,
        "type": "collection",
        "title": "Романтические фильмы",
        "hru": "romantic-movies",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 1242,
          "withpreorderable": true,
          "relevance_cookie": "1021920,884740,1332850,875100,1061970,3575310,1709010,2139280,1658490,4148450,1056250,1371610,1868360,80041,703770,516300,143681,4240210,1153610,1709840"
        }
      },
      {
        "id": 95,
        "type": "collection",
        "title": "Голливудские семейные фильмы",
        "hru": "gollivudskie-semejnyie",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 2136,
          "withpreorderable": true,
          "relevance_cookie": "2061040,628090,874990,1061000,1744570,4194310,1000080,1746850"
        }
      },
      {
        "id": 25,
        "type": "collection",
        "title": "Комедийные боевики",
        "hru": "action-comedy",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 2055,
          "withpreorderable": true,
          "relevance_cookie": "1384470,1587690,4336990,1024190,2124400,1382790,1149840,1324470,1101710,4144050"
        }
      },
      {
        "id": 156,
        "type": "collection",
        "title": "Русские сериалы",
        "hru": "russian-series",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 935,
          "withpreorderable": true,
          "relevance_cookie": "142551,92251,141941,99831,141831,142761,72701,95721,125121,120411,92451,102031,121311,140981,92491,108561,142571,71281,132551,115561"
        }
      },
      {
        "id": 144,
        "type": "collection",
        "title": "Исторические боевики",
        "hru": "istoricheskie-boeviki",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 60,
          "withpreorderable": true,
          "relevance_cookie": "1071730,1590260,999820,1715780,335340,1270310,1702760,570410,1771920,24940,1543290,1122640"
        }
      },
      {
        "id": 21,
        "type": "collection",
        "title": "Скандинавское кино",
        "hru": "skandinavskoe_kino",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 1255,
          "withpreorderable": true,
          "relevance_cookie": "1034040,1143810,1938010,2219400,2165080,4145640,2644160,4239730,1451460,2238480,1642660,1560660,1543370,1122640"
        }
      },
      {
        "id": 38,
        "type": "collection",
        "title": "Мистические фильмы",
        "hru": "movies-mystical",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 1418,
          "withpreorderable": true,
          "relevance_cookie": "4241670,1987840,1334210,1074240,4300270,2074020,79950,4241660,4206600"
        }
      },
      {
        "id": 49,
        "type": "collection",
        "title": "Приключенческие мелодрамы",
        "hru": "priklyuchencheskie-melodramyi",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 1400,
          "withpreorderable": true,
          "relevance_cookie": "516300,876550,69311,570410,1334050,1033690,119951,1123440"
        }
      },
      {
        "id": 164,
        "type": "collection",
        "title": "Психологические триллеры",
        "hru": "psychological-thrillers",
        "groot_identifier": "collection",
        "version": 1,
        "groot_params": {
          "ui_type": "collection",
          "ui_id": "collection"
        },
        "request_params": {
          "sort": "relevance",
          "id": 58,
          "withpreorderable": true,
          "relevance_cookie": "1034580,607970,1855040,605460,1363470"
        }
      }
    ],
    "tabs": []
  },
  "session_data": "eyJ1aWQiOjc3MjA1NjA3NTExMzA2MDB9.X_b_NA.EED35a2YHgVVru-4ILRyVTbkRmg"
}
 */
