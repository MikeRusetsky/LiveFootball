package com.mikerusetsky.livefootball.data

import com.mikerusetsky.livefootball.data.entity.LeagueDAO
import com.mikerusetsky.livefootball.domain.League
import java.util.concurrent.Executors

class MainRepository (private val leagueDao: LeagueDAO) {
    fun putToDb(leagues: List<League>) {

        Executors.newSingleThreadExecutor().execute {
            leagueDao.insertAll(leagues)
        }
    }
    fun getAllFromDB(): List<League> {
        return leagueDao.getCachedFilms()
    }
}