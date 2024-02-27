package com.mikerusetsky.livefootball.data

import com.mikerusetsky.livefootball.data.models.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballAPI {

    @GET("schedules/seasons/{id}")
//    @Headers("api_token: tBhwJqxvWeiePWY39CrGEcIUd3pMnI1KJ1TWp8aqIs3FVebooyNlFAf1bw4R")
    suspend fun getSchedulesBySeasonId(@Path("id") seasonId: String = "21787", @Query("api_token") token: String = "tBhwJqxvWeiePWY39CrGEcIUd3pMnI1KJ1TWp8aqIs3FVebooyNlFAf1bw4R"): MatchResponse

}