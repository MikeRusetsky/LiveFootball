package com.mikerusetsky.livefootball.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikerusetsky.livefootball.data.entity.LeagueDAO
import com.mikerusetsky.livefootball.domain.League

@Database(entities = [League::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): LeagueDAO
}