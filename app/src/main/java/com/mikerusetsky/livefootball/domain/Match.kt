package com.mikerusetsky.livefootball.domain

import java.util.Date

data class Match (
    val id: Int,
    val name: String,
    val startingAt: Date,
    val teams: List<Team>
)