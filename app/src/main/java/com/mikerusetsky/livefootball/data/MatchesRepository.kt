package com.mikerusetsky.livefootball.data

import com.mikerusetsky.livefootball.domain.Match

interface MatchesRepository {

    suspend fun getMatches(): List<Match>

}