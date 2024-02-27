package com.mikerusetsky.livefootball.data.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class MatchResponse (
    @SerializedName("data") val data: List<SeasonRemote>
)

data class SeasonRemote(
    @SerializedName("id") val id: Int,
    val rounds: List<MatchRemote>
)

data class MatchRemote (
    val id: Int,
    val name: String,
    @SerializedName("starting_at") val startingAt: Date,
    val fixtures: List<FixtureRemote>
)

data class FixtureRemote(
    val id: Int,
    val name: String,
    @SerializedName("starting_at") val startingAt: Date,
    val participants: List<TeamRemote>
)

data class TeamRemote (
    val id: Int,
    val name: String,
    @SerializedName("short_code") val shortCode: String,
    @SerializedName("image_path") val image: String,
)