// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json(JsonConfiguration.Stable)
// val catalogAnswer = json.parse(CatalogAnswer.serializer(), jsonString)

package com.example.kmmsimple.shared.iviapi.collections

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

@Serializable
data class CatalogAnswer(
    val result: List<Movie>? = emptyList(),
    val count: Long? = null,
)

@Serializable
data class Movie(
    @SerialName("localization_lang_id")
    val localizationLangID: Long? = null,

    @SerialName("localization_lang_name")
    val localizationLangName: LocalizationLangName? = null,

    @SerialName("localization_lang_selfname")
    val localizationLangSelfname: LocalizationLangSelfname? = null,

    @SerialName("localization_lang_title")
    val localizationLangTitle: LocalizationTitle? = null,

    @SerialName("localization_type_title")
    val localizationTypeTitle: LocalizationTitle? = null,

    @SerialName("allow_download")
    val allowDownload: Boolean? = null,

    @SerialName("available_to_buy_on_mobile")
    val availableToBuyOnMobile: Boolean? = null,

    @SerialName("best_watch_before")
    val bestWatchBefore: String? = null,

    val categories: List<Long>? = emptyList(),

    @SerialName("content_paid_types")
    val contentPaidTypes: List<String/*PaidType*/>? = emptyList(),

    val country: Long? = null,
    val description: String? = null,

    @SerialName("drm_only")
    val drmOnly: Boolean? = null,

/*
    @SerialName("extra_properties")
    val extraProperties: ExtraProperties? = null,
*/

    @SerialName("fullhd_available")
    val fullhdAvailable: Boolean? = null,

    @SerialName("fullhd_available_all")
    val fullhdAvailableAll: Boolean? = null,

    val genres: List<Long>? = emptyList(),

    @SerialName("has_5_1")
    val has5_1: Boolean? = null,

    @SerialName("has_awards")
    val hasAwards: Boolean? = null,

    @SerialName("has_comments")
    val hasComments: Boolean? = null,

    @SerialName("has_creators")
    val hasCreators: Boolean? = null,

    @SerialName("has_reviews")
    val hasReviews: Boolean? = null,

    @SerialName("hd_available")
    val hdAvailable: Boolean? = null,

    @SerialName("hd_available_all")
    val hdAvailableAll: Boolean? = null,

    val id: Long? = null,

    @SerialName("imdb_rating")
    val imdbRating: String? = null,

    @SerialName("is_erotic")
    val isErotic: Boolean? = null,

    @SerialName("ivi_release_date")
    val iviReleaseDate: String? = null,

    @SerialName("ivi_pseudo_release_date")
    val iviPseudoReleaseDate: String? = null,

    @SerialName("ivi_rating")
    val iviRating: String? = null,

    @SerialName("ivi_rating_10")
    val iviRating10: Double? = null,

    @SerialName("ivi_rating_10_count")
    val iviRating10_Count: Long? = null,

/*
    @SerialName("ivi_release_info")
    val iviReleaseInfo: IviReleaseInfo? = null,
*/

    val kind: Long? = null,

    @SerialName("kp_id")
    val kpID: Long? = null,

    @SerialName("kp_rating")
    val kpRating: String? = null,

    @SerialName("object_type")
    val objectType: ObjectType? = null,

    @SerialName("orig_title")
    val origTitle: String? = null,

    @SerialName("promo_images")
    val promoImages: List<Storyboard>? = emptyList(),

    val rating: Rating? = null,

    @SerialName("release_date")
    val releaseDate: String? = null,

    val restrict: Long? = null,

    @SerialName("sharing_disabled")
    val sharingDisabled: Boolean? = null,

    val synopsis: String? = null,
    val title: String? = null,

    @SerialName("used_to_be_paid")
    val usedToBePaid: Boolean? = null,

    @SerialName("wow_point_time")
    val wowPointTime: Long? = null,

    val year: Long? = null,

    @SerialName("has_origin_localization")
    val hasOriginLocalization: Boolean? = null,

    @SerialName("share_link")
    val shareLink: String? = null,

    @SerialName("additional_data")
    var additionalData: List<AdditionalDatum>? = emptyList(),

    val artists: List<String>? = emptyList(),

    @SerialName("available_in_countries")
    val availableInCountries: List<String>? = emptyList(),

    @SerialName("subsites_availability")
    val subsitesAvailability: List<SubsitesAvailability>? = emptyList(),

    @SerialName("content_paid_type")
    val contentPaidType: String/*PaidType*/? = null,

    @SerialName("formats_5_1")
    val formats5_1: List<String>? = emptyList(),

    @SerialName("credits_begin_time")
    val creditsBeginTime: Long? = null,

    val duration: String? = null,

    @SerialName("duration_minutes")
    val durationMinutes: Long? = null,

    val storyboard: Storyboard? = null,

    @SerialName("vr_allow_download")
    val vrAllowDownload: Boolean? = null,

    @SerialName("er_allow_download")
    val erAllowDownload: Boolean? = null,

    @SerialName("poster_originals")
    val posterOriginals: List<PosterOriginal>? = emptyList(),

    val thumbnails: List<PosterOriginal>? = emptyList(),
    val subtitles: List<String>? = emptyList(),

    @SerialName("badge_name")
    val badgeName: String? = null,

    @SerialName("airplay_availability")
    val airplayAvailability: Boolean? = null,

    val background: Background? = null,

    @SerialName("localization_ids")
    val localizationIDS: List<Long>? = emptyList(),

    val localizations: List<String>? = emptyList(),

    @SerialName("thumb_originals")
    val thumbOriginals: List<PosterOriginal>? = emptyList(),

/*
    @SerialName("music_artists")
    val musicArtists: Any? = null,
*/

/*
    @SerialName("music_likes")
    val musicLikes: JsonArray? = null,

    val products: JsonArray? = null,

    @SerialName("other_versions")
    val otherVersions: JsonArray? = null,
*/

    @SerialName("affiliate_subscription_paid_type")
    val affiliateSubscriptionPaidType: String? = null,

    @SerialName("episode_sort_order")
    val episodeSortOrder: EpisodeSortOrder? = null,

    @SerialName("has_upcoming_episodes")
    val hasUpcomingEpisodes: Boolean? = null,

    val hru: String? = null,
    val years: List<Long>? = emptyList(),
    val episodes: List<Long>? = emptyList(),

    @SerialName("ivi_id")
    val iviID: Long? = null,

    @SerialName("seasons_content_total")
    val seasonsContentTotal: Map<String, Long>? = emptyMap(),

    val seasons: List<Long>? = emptyList(),

    @SerialName("total_contents")
    val totalContents: Long? = null,

    @SerialName("seasons_count")
    val seasonsCount: Long? = null,

    @SerialName("seasons_description")
    var seasonsDescription: MutableMap<String, String?> = mutableMapOf(),

    @SerialName("seasons_extra_info")
    val seasonsExtraInfo: Map<String, SeasonsExtraInfo>? = emptyMap(),

    @SerialName("3d_available_all")
    val the3DAvailableAll: Boolean? = null,

    val budget: Long? = null,

    @SerialName("budget_million")
    val budgetMillion: String? = null,

    @SerialName("gross_russia")
    val grossRussia: Long? = null,

    @SerialName("gross_russia_million")
    val grossRussiaMillion: String? = null,

    @SerialName("gross_world")
    val grossWorld: Long? = null,

    @SerialName("gross_world_million")
    val grossWorldMillion: String? = null,

    val shields: List<Shield>? = emptyList(),

    @SerialName("gross_usa")
    val grossUsa: Long? = null,

    @SerialName("gross_usa_million")
    val grossUsaMillion: String? = null,

    @SerialName("gross_weekend")
    val grossWeekend: Long? = null,

    @SerialName("gross_weekend_million")
    val grossWeekendMillion: String? = null

) {

    fun paidSubtitle() = when(primaryType()) {
        PaidTypes.UNKNOWN -> ""
        PaidTypes.AVOD -> "Бесплатно"
        PaidTypes.SVOD -> "Подписка"
        PaidTypes.EST -> "Покупка"
        PaidTypes.TVOD -> "Аренда"
    }

    fun primaryType() = when {
        contentPaidTypes == null -> PaidTypes.UNKNOWN
        contentPaidTypes.contains(PaidType.Avod) -> PaidTypes.AVOD
        contentPaidTypes.contains(PaidType.Svod) -> PaidTypes.SVOD
        contentPaidTypes.contains(PaidType.Est) -> PaidTypes.EST
        contentPaidTypes.contains(PaidType.Tvod) -> PaidTypes.TVOD
        else -> PaidTypes.UNKNOWN
    }
}

@Serializable
data class AdditionalDatum(
    @SerialName("additional_data_id")
    val additionalDataID: Long? = null,

    @SerialName("data_type")
    val dataType: DataType? = null,

    @SerialName("date_insert")
    val dateInsert: String? = null,

    val priority: Long? = null,
    val title: String? = null,

    @SerialName("is_paid")
    val isPaid: Boolean? = null,

    @SerialName("use_for_background")
    val useForBackground: Boolean? = null,

    val duration: String? = null,
    val storyboard: Storyboard? = null,
    val preview: String? = null
)

@Serializable(with = DataType.Companion::class)
enum class DataType(val value: String) {
    EditorsChoice("editors_choice"),
    Trailer("trailer"),
    Unknown("");

    companion object : KSerializer<DataType> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.DataType",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): DataType = when (val value = decoder.decodeString()) {
            "editors_choice" -> EditorsChoice
            "trailer" -> Trailer
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: DataType) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable
data class Storyboard(
    val url: String? = null,

    @SerialName("content_format")
    val contentFormat: ContentFormat? = null,

    @SerialName("size_in_bytes")
    val sizeInBytes: Long? = null,

    val width: Long? = null,
    val height: Long? = null
)

@Serializable(with = ContentFormat.Companion::class)
enum class ContentFormat(val value: String) {
    BackgroundImage1280X720("BackgroundImage-1280x720"),
    MobilePromo1024X449("MobilePromo-1024x449"),
    MobilePromo1098X416("MobilePromo-1098x416"),
    MobilePromo1156X352("MobilePromo-1156x352"),
    MobilePromo1216X460("MobilePromo-1216x460"),
    MobilePromo1217X373("MobilePromo-1217x373"),
    MobilePromo1536X468("MobilePromo-1536x468"),
    MobilePromo1680X530("MobilePromo-1680x530"),
    MobilePromo1920X728("MobilePromo-1920x728"),
    MobilePromo220X124("MobilePromo-220x124"),
    MobilePromo480X636("MobilePromo-480x636"),
    MobilePromo980X330("MobilePromo-980x330"),
    Storyboard("Storyboard"),
    Unknown("");

    companion object : KSerializer<ContentFormat> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.ContentFormat",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): ContentFormat = when (val value = decoder.decodeString()) {
            "BackgroundImage-1280x720" -> BackgroundImage1280X720
            "MobilePromo-1024x449" -> MobilePromo1024X449
            "MobilePromo-1098x416" -> MobilePromo1098X416
            "MobilePromo-1156x352" -> MobilePromo1156X352
            "MobilePromo-1216x460" -> MobilePromo1216X460
            "MobilePromo-1217x373" -> MobilePromo1217X373
            "MobilePromo-1536x468" -> MobilePromo1536X468
            "MobilePromo-1680x530" -> MobilePromo1680X530
            "MobilePromo-1920x728" -> MobilePromo1920X728
            "MobilePromo-220x124" -> MobilePromo220X124
            "MobilePromo-480x636" -> MobilePromo480X636
            "MobilePromo-980x330" -> MobilePromo980X330
            "Storyboard" -> Storyboard
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: ContentFormat) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable
data class Background(
    val path: String? = null,
    val type: String? = null
)

enum class PaidTypes {
    AVOD, SVOD, TVOD, EST, UNKNOWN
}
class PaidType {

    companion object {
        const val Avod = "AVOD"
        const val Svod = "SVOD"
        const val Tvod = "TVOD"
        const val Est = "EST"
    }
}
/*
@Serializable(with = PaidType.Companion::class)
enum class PaidType(val value: String) {
    Avod("AVOD"),
    Svod("SVOD"),
    Tvod("TVOD"),
    Est("EST"),
    Unknown("");

    companion object : KSerializer<PaidType> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.PaidType",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): PaidType = when (val value = decoder.decodeString()) {
            "AVOD" -> Avod
            "SVOD" -> Svod
            "TVOD" -> Tvod
            "EST" -> Est
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: PaidType) {
            return encoder.encodeString(value.value)
        }
    }
}
*/

@Serializable(with = EpisodeSortOrder.Companion::class)
enum class EpisodeSortOrder(val value: String) {
    St("st"), Unknown("");

    companion object : KSerializer<EpisodeSortOrder> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.EpisodeSortOrder",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): EpisodeSortOrder = when (val value = decoder.decodeString()) {
            "st" -> St
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: EpisodeSortOrder) {
            return encoder.encodeString(value.value)
        }
    }
}

/*
class ExtraProperties()
*/

/*
@Serializable
data class IviReleaseInfo(
    @SerialName("date_interval_min")
    val dateIntervalMin: Any? = null,

    @SerialName("date_interval_max")
    val dateIntervalMax: Any? = null
)
*/

@Serializable(with = LocalizationLangName.Companion::class)
enum class LocalizationLangName(val value: String) {
    Ru("RU"),
    Unknown("");

    companion object : KSerializer<LocalizationLangName> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.LocalizationLangName",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): LocalizationLangName = when (val value = decoder.decodeString()) {
            "RU" -> Ru
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: LocalizationLangName) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable(with = LocalizationLangSelfname.Companion::class)
enum class LocalizationLangSelfname(val value: String) {
    Ru("РУС"),
    Unknown("");

    companion object : KSerializer<LocalizationLangSelfname> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.LocalizationLangSelfname",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): LocalizationLangSelfname =
            when (val value = decoder.decodeString()) {
                "РУС" -> Ru
                else -> Unknown
            }

        override fun serialize(encoder: Encoder, value: LocalizationLangSelfname) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable(with = LocalizationTitle.Companion::class)
enum class LocalizationTitle(val value: String) {
    Ru("Русский"),
    Unknown("");

    companion object : KSerializer<LocalizationTitle> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.LocalizationTitle",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): LocalizationTitle = when (val value = decoder.decodeString()) {
            "Русский" -> Ru
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: LocalizationTitle) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable(with = ObjectType.Companion::class)
enum class ObjectType(val value: String) {
    Compilation("compilation"),
    Video("video"),
    Unknown("");

    companion object : KSerializer<ObjectType> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.ObjectType",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): ObjectType = when (val value = decoder.decodeString()) {
            "compilation" -> Compilation
            "video" -> Video
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: ObjectType) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable
data class PosterOriginal(
    val path: String? = null,
    val type: String/*Type*/? = null,
    val height: Long? = null,
    val width: Long? = null
)

class Type {
    companion object {
        const val Poster = "Poster"
    }
}
/*
@Serializable(with = Type.Companion::class)
enum class Type(val value: String) {
    B2BImageFile("B2BImageFile"),
    Poster("Poster"),
    PromoImgImageFile("PromoImgImageFile"),
    Thumbnail("Thumbnail"),
    Unknown("")
    ;

    companion object : KSerializer<Type> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.Type",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): Type = when (val value = decoder.decodeString()) {
            "B2BImageFile" -> B2BImageFile
            "Poster" -> Poster
            "PromoImgImageFile" -> PromoImgImageFile
            "Thumbnail" -> Thumbnail
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: Type) {
            return encoder.encodeString(value.value)
        }
    }
}
*/

@Serializable
data class Rating(
    val ready: Ready? = null,
    val validation: Ready? = null
)

@Serializable
data class Ready(
    val votes: Long? = null,
    val main: Double? = null,
    val director: Double? = null,
    val pretty: Double? = null,
    val actors: Double? = null,
    val story: Double? = null
)

@Serializable
data class SeasonsExtraInfo(
    @SerialName("season_id")
    val seasonID: Long? = null,

    val purchasable: Boolean? = null,
    val title: String? = null,
    val hru: String? = null,

    @SerialName("subscription_ids")
    val subscriptionIDS: List<Long>? = emptyList(),

/*
    @SerialName("ivi_release_info")
    val iviReleaseInfo: IviReleaseInfo? = null,
*/

    @SerialName("used_to_be_paid")
    val usedToBePaid: Boolean? = null,

    @SerialName("content_paid_types")
    val contentPaidTypes: List<String/*PaidType*/>? = emptyList(),

    @SerialName("allow_download")
    val allowDownload: Boolean? = null,

    @SerialName("allow_download_paid_types")
    val allowDownloadPaidTypes: List<String/*PaidType*/>? = emptyList(),

    @SerialName("min_episode")
    val minEpisode: Long? = null,

    @SerialName("max_episode")
    val maxEpisode: Long? = null,

    val fake: Boolean? = null,

    @SerialName("vr_allow_download")
    val vrAllowDownload: Boolean? = null,

    @SerialName("er_allow_download")
    val erAllowDownload: Boolean? = null
)

@Serializable
data class Shield(
    val id: Long? = null,
    val name: String? = null,

    @SerialName("short_name")
    val shortName: String? = null,

    @SerialName("ds_style")
    val dsStyle: String? = null,

    val type: String? = null
)

@Serializable(with = SubsitesAvailability.Companion::class)
enum class SubsitesAvailability(val value: String) {
    Android("android"),
    Ios("ios"),
    Smarttv("smarttv"),
    Web("web"),
    Winphone("winphone"),
    Unknown("");

    companion object : KSerializer<SubsitesAvailability> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor(
                    "com.example.kmmsimple.shared.iviapi.collections.SubsitesAvailability",
                    PrimitiveKind.STRING
                )
            }

        override fun deserialize(decoder: Decoder): SubsitesAvailability = when (val value = decoder.decodeString()) {
            "android" -> Android
            "ios" -> Ios
            "smarttv" -> Smarttv
            "web" -> Web
            "winphone" -> Winphone
            else -> Unknown
        }

        override fun serialize(encoder: Encoder, value: SubsitesAvailability) {
            return encoder.encodeString(value.value)
        }
    }
}

/*
{
  "result": [
    {
      "localization_lang_id": 1,
      "localization_lang_name": "RU",
      "localization_lang_selfname": "РУС",
      "localization_lang_title": "Русский",
      "localization_type_title": "Русский",
      "allow_download": true,
      "available_to_buy_on_mobile": true,
      "best_watch_before": "2021-08-30",
      "categories": [
        17
      ],
      "content_paid_types": [
        "AVOD",
        "SVOD"
      ],
      "country": 1,
      "description": "Князь Киевский серьезно заболел. Он приказывает привезти из Царьграда его племянницу и наследницу Забаву. Трое знаменитых друзей-богатырей отправляются за Забавой в далекое путешествие. Любимые герои возвращаются для новых подвигов, приключений и веселья в девятой главе культовой мультипликационной франшизы «Три богатыря и Наследница престола». Режиссерское место занял двукратный номинант на «Оскар» Константин Бронзит («Алеша Попович и Тугарин Змей»).\r\n\r\nОпять не сидится на месте защитникам Руси – Алеше Поповичу, Добрыне Никитичу и Илье Муромцу. Они получают задание от Князя Киевского, который слег в постель с опасным недугом. Всех беспокоит вопрос – кто же займет его место на престоле? Князь вспоминает о своей любимой красавице-племяннице Забаве, которая уехала учиться в Царьград. Трем богатырям поручают доставить ее на родину и оберегать от интриг коварных охотников до власти. Один из них, хитроумный правитель Царьграда, уже надумал женить на Забаве своего непутевого сына.\r\n\r\nПриглашаем всей семьей посмотреть анимационную приключенческую комедию «Три богатыря и Наследница престола» в нашем онлайн-кинотеатре.",
      "drm_only": false,
      "extra_properties": {},
      "fullhd_available": true,
      "fullhd_available_all": true,
      "genres": [
        255,
        251,
        219,
        123,
        215
      ],
      "has_5_1": true,
      "has_awards": false,
      "has_comments": true,
      "has_creators": true,
      "has_reviews": true,
      "hd_available": true,
      "hd_available_all": true,
      "id": 212015,
      "imdb_rating": "5.50",
      "is_erotic": false,
      "ivi_release_date": "2019-05-01",
      "ivi_pseudo_release_date": "2019-05-01",
      "ivi_rating": "2.95",
      "ivi_rating_10": 5.9,
      "ivi_rating_10_count": 109722,
      "ivi_release_info": {
        "date_interval_min": null,
        "date_interval_max": null
      },
      "kind": 1,
      "kp_id": 1113014,
      "kp_rating": "6.41",
      "object_type": "video",
      "orig_title": "",
      "promo_images": [
        {
          "width": 1536,
          "content_format": "MobilePromo-1536x468",
          "height": 468,
          "url": "https://thumbs.dfs.ivi.ru/storage9/contents/b/2/d719e1f894bf61c35b5d8ab39eba15.jpg"
        },
        {
          "width": 980,
          "content_format": "MobilePromo-980x330",
          "height": 330,
          "url": "https://thumbs.dfs.ivi.ru/storage26/contents/f/8/c2e54013d38600bd4655a2f02c748d.jpg"
        },
        {
          "width": 1024,
          "content_format": "MobilePromo-1024x449",
          "height": 449,
          "url": "https://thumbs.dfs.ivi.ru/storage2/contents/6/1/c37caa5becfb05e3b7bdcdd88b86b6.jpg"
        },
        {
          "width": 1156,
          "content_format": "MobilePromo-1156x352",
          "height": 352,
          "url": "https://thumbs.dfs.ivi.ru/storage23/contents/0/a/a26ff064579cda09913ea409f0a045.jpg"
        },
        {
          "width": 1217,
          "content_format": "MobilePromo-1217x373",
          "height": 373,
          "url": "https://thumbs.dfs.ivi.ru/storage15/contents/5/b/e5f823c7a5876cea64b8f41be912bc.jpg"
        },
        {
          "width": 1280,
          "content_format": "BackgroundImage-1280x720",
          "height": 720,
          "url": "https://thumbs.dfs.ivi.ru/storage15/contents/0/c/94c3aa13ee888810388aa8af95deb6.jpg"
        },
        {
          "width": 1536,
          "content_format": "MobilePromo-1536x468",
          "height": 468,
          "url": "https://thumbs.dfs.ivi.ru/storage4/contents/6/8/db1e41e4f399cd3fa13b706fddf878.jpg"
        },
        {
          "width": 980,
          "content_format": "MobilePromo-980x330",
          "height": 330,
          "url": "https://thumbs.dfs.ivi.ru/storage23/contents/1/5/bdd9f6eec7cac61b9fddf9bfbe1421.jpg"
        },
        {
          "width": 1024,
          "content_format": "MobilePromo-1024x449",
          "height": 449,
          "url": "https://thumbs.dfs.ivi.ru/storage29/contents/b/a/7d032f0730ddd9cac10ecfb338c15b.jpg"
        },
        {
          "width": 1156,
          "content_format": "MobilePromo-1156x352",
          "height": 352,
          "url": "https://thumbs.dfs.ivi.ru/storage2/contents/d/f/b62c87debef519168164ac9d42bb5c.jpg"
        },
        {
          "width": 1217,
          "content_format": "MobilePromo-1217x373",
          "height": 373,
          "url": "https://thumbs.dfs.ivi.ru/storage32/contents/5/e/fb04b96b3a29d041a1b6acc4812666.jpg"
        }
      ],
      "rating": {
        "ready": {
          "votes": 45823,
          "main": 8.21,
          "director": 0.64,
          "pretty": 0.67,
          "actors": 0.6,
          "story": 0.76
        },
        "validation": {
          "votes": 45823,
          "main": 8.21,
          "director": 0.64,
          "pretty": 0.67,
          "actors": 0.6,
          "story": 0.76
        }
      },
      "release_date": "2018-01-01",
      "restrict": 6,
      "sharing_disabled": true,
      "synopsis": "Князь Киевский серьезно заболел. Он приказывает привезти из Царьграда его племянницу и наследницу Забаву. Трое знаменитых друзей-богатырей отправляются за Забавой в далекое путешествие.",
      "title": "Три богатыря и Наследница престола",
      "used_to_be_paid": true,
      "wow_point_time": 512,
      "year": 2018,
      "has_origin_localization": false,
      "share_link": "https://www.ivi.ru/watch/212015",
      "additional_data": [
        {
          "additional_data_id": 26462,
          "data_type": "trailer",
          "date_insert": "2018-11-08",
          "priority": 2,
          "title": "Трейлер",
          "is_paid": false,
          "use_for_background": true,
          "duration": "0:01:39",
          "storyboard": {
            "url": "https://storyboard.ivi.ru/storage9/contents/0/7/b9ef12931590f38fba0a0eadd9a4e9.clptrp",
            "content_format": "Storyboard",
            "size_in_bytes": 4718592,
            "width": 640,
            "height": 360
          },
          "preview": "https://thumbs.dfs.ivi.ru/storage29/contents/c/c/b3b39b97f63bbfe27013bb683f3bb6.jpg"
        },
        {
          "additional_data_id": 23158,
          "data_type": "trailer",
          "date_insert": "2018-05-24",
          "priority": 1,
          "title": "Тизер-трейлер",
          "is_paid": false,
          "use_for_background": false,
          "duration": "0:01:05",
          "preview": "https://thumbs.dfs.ivi.ru/storage37/contents/8/2/777cafa89a21e31f80088b076d3cd0.jpg"
        }
      ],
      "artists": [
        "Михаил Черняк",
        "Сергей Маковецкий",
        "Дмитрий Быковский-Ромашов"
      ],
      "available_in_countries": [
        "FI",
        "MT",
        "MH",
        "TV",
        "CW",
        "HR",
        "CZ",
        "VC",
        "EE",
        "CK",
        "NC",
        "AL",
        "EH",
        "AF",
        "CL",
        "GL",
        "MC",
        "PS",
        "NF",
        "SZ",
        "BL",
        "KW",
        "TF",
        "MD",
        "LK",
        "BW",
        "RO",
        "MU",
        "KP",
        "IE",
        "JM",
        "MS",
        "PM",
        "MX",
        "LB",
        "RS",
        "GE",
        "GD",
        "BR",
        "EG",
        "LS",
        "TD",
        "VA",
        "GH",
        "TJ",
        "KM",
        "SI",
        "AD",
        "MO",
        "IS",
        "HM",
        "ES",
        "SD",
        "TM",
        "GI",
        "AI",
        "AW",
        "UG",
        "JE",
        "TK",
        "BH",
        "PG",
        "CO",
        "GG",
        "PF",
        "AR",
        "BO",
        "LV",
        "RU",
        "TN",
        "BT",
        "SJ",
        "FK",
        "NE",
        "SE",
        "WS",
        "SO",
        "BQ",
        "FJ",
        "HT",
        "NZ",
        "SM",
        "CH",
        "NO",
        "BI",
        "GS",
        "KG",
        "BF",
        "BY",
        "BA",
        "CM",
        "MY",
        "GB",
        "GM",
        "HU",
        "IT",
        "VN",
        "ZW",
        "GW",
        "SR",
        "LU",
        "BS",
        "ER",
        "BM",
        "YE",
        "BV",
        "DZ",
        "MK",
        "FO",
        "CX",
        "AT",
        "SX",
        "AX",
        "IO",
        "LI",
        "GY",
        "DE",
        "AQ",
        "GP",
        "BB",
        "BG",
        "UZ",
        "NA",
        "CN",
        "PN",
        "LY",
        "RW",
        "TT",
        "NL",
        "MN",
        "WF",
        "CV",
        "KY",
        "MG",
        "ST",
        "LR",
        "CF",
        "GQ",
        "HN",
        "GN",
        "CD",
        "LC",
        "PA",
        "GA",
        "DJ",
        "RE",
        "CA",
        "KH",
        "TR",
        "ZA",
        "VE",
        "SC",
        "SS",
        "TC",
        "GF",
        "GT",
        "NP",
        "TW",
        "AZ",
        "DK",
        "TZ",
        "FM",
        "AO",
        "BN",
        "ZM",
        "SA",
        "SH",
        "ME",
        "SN",
        "MZ",
        "MP",
        "VU",
        "BZ",
        "NR",
        "PT",
        "YT",
        "NI",
        "SY",
        "AU",
        "MW",
        "CC",
        "SB",
        "US",
        "TG",
        "MV",
        "SK",
        "UY",
        "IR",
        "NG",
        "SV",
        "KE",
        "HK",
        "IQ",
        "BD",
        "EC",
        "IL",
        "KR",
        "SL",
        "VG",
        "AE",
        "PL",
        "IN",
        "MQ",
        "UM",
        "SG",
        "JO",
        "PH",
        "ML",
        "QA",
        "ET",
        "AM",
        "AS",
        "JP",
        "GU",
        "CR",
        "FR",
        "AG",
        "MF",
        "CU",
        "PY",
        "PE",
        "IM",
        "MM",
        "GR",
        "KN",
        "PR",
        "VI",
        "CY",
        "TL",
        "LT",
        "DO",
        "LA",
        "TO",
        "ID",
        "KI",
        "TH",
        "KZ",
        "DM",
        "OM",
        "PK",
        "MA",
        "BE",
        "PW",
        "MR",
        "CI",
        "CG",
        "BJ"
      ],
      "subsites_availability": [
        "android",
        "ios",
        "smarttv",
        "web",
        "winphone"
      ],
      "content_paid_type": "AVOD",
      "formats_5_1": [
        "MP4-HD1080",
        "MP4-HD720",
        "original"
      ],
      "credits_begin_time": 4651,
      "duration": "1:21:19",
      "duration_minutes": 81,
      "storyboard": {
        "url": "https://storyboard.ivi.ru/storage29/contents/4/8/39d6a703d5c9e7a3bb3ee840cbb0ea.clptrp",
        "content_format": "Storyboard",
        "size_in_bytes": 41943040,
        "width": 640,
        "height": 360
      },
      "vr_allow_download": true,
      "er_allow_download": false,
      "poster_originals": [
        {
          "path": "https://thumbs.dfs.ivi.ru/storage28/contents/3/3/bf3efb98b469ddb281c23a4e3c9a43.jpg",
          "type": "Poster",
          "height": 1200,
          "width": 782
        }
      ],
      "thumbnails": [
        {
          "type": "PromoImgImageFile",
          "path": "https://thumbs.dfs.ivi.ru/storage28/contents/3/3/bf3efb98b469ddb281c23a4e3c9a43.jpg",
          "height": 1200,
          "width": 782
        },
        {
          "type": "B2BImageFile",
          "path": "https://thumbs.dfs.ivi.ru/storage33/contents/f/6/89e281b0c0341b8d0598d902814397.jpg",
          "height": 480,
          "width": 640
        }
      ],
      "subtitles": [
        "Английский"
      ],
      "badge_name": "",
      "airplay_availability": false,
      "background": {
        "path": "https://thumbs.dfs.ivi.ru/storage15/contents/d/9/b6a21c4f9d34cd27f7a5fe43d03e44.jpg",
        "type": "BackgroundImage"
      },
      "localization_ids": [],
      "localizations": [],
      "thumb_originals": [
        {
          "path": "https://thumbs.dfs.ivi.ru/storage33/contents/f/6/89e281b0c0341b8d0598d902814397.jpg",
          "type": "Thumbnail",
          "height": 480,
          "width": 640
        }
      ],
      "music_artists": null,
      "music_likes": [],
      "products": [],
      "other_versions": [],
      "affiliate_subscription_paid_type": ""
    }
  ],
  "count": 861,
  "meta": {
    "property_filters": [
      {
        "id": 2070,
        "title": "2019"
      },
      {
        "id": 2076,
        "title": "2018"
      },
      {
        "id": 2075,
        "title": "2017"
      },
      {
        "id": 2088,
        "title": "Для детей"
      },
      {
        "id": 2069,
        "title": "США"
      },
      {
        "id": 2054,
        "title": "Для всей семьи"
      },
      {
        "id": 2086,
        "title": "Сказки"
      },
      {
        "id": 2051,
        "title": "Россия"
      },
      {
        "id": 2137,
        "title": "Путешествия"
      },
      {
        "id": 2087,
        "title": "Про магию"
      },
      {
        "id": 2074,
        "title": "Приключения"
      },
      {
        "id": 2055,
        "title": "Захватывающие"
      },
      {
        "id": 2053,
        "title": "Зрелищные"
      },
      {
        "id": 2068,
        "title": "На основе книг"
      },
      {
        "id": 2058,
        "title": "Вдохновляющие"
      },
      {
        "id": 2236,
        "title": "Комедия"
      },
      {
        "id": 2084,
        "title": "Фэнтези"
      },
      {
        "id": 2139,
        "title": "Принцессы"
      },
      {
        "id": 2111,
        "title": "Супергерои"
      },
      {
        "id": 2062,
        "title": "Про любовь"
      },
      {
        "id": 2096,
        "title": "Машины"
      },
      {
        "id": 2315,
        "title": "Развивающие"
      }
    ]
  },
  "session_data": "eyJ1aWQiOjc3MjA1NjA3NTExMzA2MDB9.X_cFoQ.gvd9xYx9hjmzgwkjYkcNbdb5sE0"
}
 */