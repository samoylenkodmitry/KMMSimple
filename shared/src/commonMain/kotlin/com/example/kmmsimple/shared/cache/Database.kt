package com.example.kmmsimple.shared.cache

import com.example.kmmsimple.shared.Links
import com.example.kmmsimple.shared.RocketLaunch

class Database(driver: DatabaseDriverFactory) {
    val db = AppDatabase(driver.createDriver())
    val query = db.appDatabaseQueries
    fun clearDb() {
        query.transaction {
            query.removeAllLaunches()
            query.removeAllRockets()
        }
    }

    fun getLaunches() = query.selectAllLaunchesInfo(::map).executeAsList()

    fun map(
        flightNumber: Long,
        missionName: String,
        launchYear: Int,
        rocketId: String,
        details: String?,
        launchSuccess: Boolean?,
        launchDateUTC: String,
        missionPatchUrl: String?,
        articleUrl: String?,
        rocket_id: String?,
        name: String?,
        type: String?
    ): RocketLaunch {
        return RocketLaunch(
            flightNumber = flightNumber.toInt(),
            missionName = missionName,
            launchYear = launchYear,
            details = details,
            launchDateUTC = launchDateUTC,
            launchSuccess = launchSuccess,
            rocket = com.example.kmmsimple.shared.Rocket(
                id = rocketId,
                name = name!!,
                type = type!!
            ),
            links = Links(
                missionPatchUrl = missionPatchUrl,
                articleUrl = articleUrl
            )
        )
    }

    fun createLaunches(launches: List<RocketLaunch>) {
        query.transaction {
            launches.forEach { l ->
                val r = query.selectRocketById(l.rocket.id).executeAsOneOrNull()
                if (r == null) insertRocket(l)
                insertLaunch(l)
            }
        }
    }

    fun insertRocket(launch: RocketLaunch) {
        query.insertRocket(
            id = launch.rocket.id,
            name = launch.rocket.name,
            type = launch.rocket.type
        )
    }

    fun insertLaunch(launch: RocketLaunch) {
        query.insertLaunch(
            flightNumber = launch.flightNumber.toLong(),
            missionName = launch.missionName,
            launchYear = launch.launchYear,
            rocketId = launch.rocket.id,
            details = launch.details,
            launchSuccess = launch.launchSuccess ?: false,
            launchDateUTC = launch.launchDateUTC,
            missionPatchUrl = launch.links.missionPatchUrl,
            articleUrl = launch.links.articleUrl
        )
    }
}