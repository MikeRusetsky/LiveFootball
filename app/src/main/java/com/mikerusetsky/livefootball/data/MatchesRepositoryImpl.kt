package com.mikerusetsky.livefootball.data

import com.mikerusetsky.livefootball.domain.Match
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val api: FootballAPI
): MatchesRepository {
    override suspend fun getMatches(): List<Match> {
        return withContext(Dispatchers.IO) {
            try {
                val season = api.getSchedulesBySeasonId().data.first()
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val now: Date = sdf.parse(sdf.format(Date()))
                val evening = Calendar.getInstance().apply {
                    this.set(android.icu.util.Calendar.HOUR, 23)
                    this.set(Calendar.MINUTE, 59)
                    this.set(Calendar.SECOND, 59)
                }

                val result = season.rounds.filter {
                    it.startingAt >= now && it.startingAt <= evening.time
                }.map { it.fixtures }.map { it.map { it.asDomain() } }

                emptyList()
            } catch (e: Exception) {
                emptyList()
            }


        }
    }
}