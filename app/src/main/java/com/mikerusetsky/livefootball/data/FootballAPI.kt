package com.mikerusetsky.livefootball.data

import com.mikerusetsky.livefootball.ApiConstants
import com.mikerusetsky.livefootball.data.models.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballAPI {

    @GET("football/leagues")
    suspend fun getAllLeagues(@Query("api_token") token: String = ApiConstants.TOKEN): List<String>

    @GET("football/seasons")
    suspend fun getAllSeasons(@Query("api_token") token: String = ApiConstants.TOKEN): List<String>

    @GET("schedules/seasons/{id}")
    suspend fun getSchedulesBySeasonId(@Path("id") seasonId: String = "21787", @Query("api_token") token: String = ApiConstants.TOKEN): MatchResponse

}