package com.mikerusetsky.livefootball.di.modules

import android.content.Context
import androidx.room.Room
import com.mikerusetsky.livefootball.data.MainRepository
import com.mikerusetsky.livefootball.data.db.AppDatabase
import com.mikerusetsky.livefootball.data.entity.LeagueDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideLeagueDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "leagues_db"
        ).build().leagueDao()

    @Provides
    @Singleton
    fun provideRepository(leagueDao: LeagueDAO) = MainRepository(leagueDao)
}