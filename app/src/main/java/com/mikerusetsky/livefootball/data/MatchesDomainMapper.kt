package com.mikerusetsky.livefootball.data

import com.mikerusetsky.livefootball.data.models.FixtureRemote
import com.mikerusetsky.livefootball.data.models.TeamRemote
import com.mikerusetsky.livefootball.domain.Match
import com.mikerusetsky.livefootball.domain.Team

fun FixtureRemote.asDomain(): Match = Match(
    id = id,
    name = name,
    startingAt = startingAt,
    teams = participants.asDomain()
)

//fun List<FixtureRemote>.asDomain(): List<Match> = this.map { it.asDomain() }

fun TeamRemote.asDomain(): Team = Team(
    id = id,
    name = name,
    shortCode = shortCode,
    image = image
)

fun List<TeamRemote>.asDomain(): List<Team> = this.map { it.asDomain() }