package com.mikerusetsky.livefootball.data.settings

import android.content.Context
import com.google.gson.Gson
import com.mikerusetsky.livefootball.domain.Settings
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val context: Context
) : SettingsRepository {

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    override fun set(settings: Settings) {
        val gson = Gson().toJson(settings)
        pref.edit().putString(PREF_KEY, gson).apply()
    }

    override fun get(): Settings {
        val json = pref.getString(PREF_KEY, null)
        return json?.let { Gson().fromJson(json, Settings::class.java) } ?: Settings()
    }

    companion object {
        private const val PREF_NAME = "settings"
        private const val PREF_KEY = "settings"
    }
}