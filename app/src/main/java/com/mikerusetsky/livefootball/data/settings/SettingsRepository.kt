package com.mikerusetsky.livefootball.data.settings

import com.mikerusetsky.livefootball.domain.Settings

interface SettingsRepository {

    fun set(settings: Settings)

    fun get(): Settings

}