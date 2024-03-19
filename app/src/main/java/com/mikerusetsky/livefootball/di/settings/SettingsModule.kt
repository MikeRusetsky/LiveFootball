package com.mikerusetsky.livefootball.di.settings

import com.mikerusetsky.livefootball.data.settings.SettingsRepository
import com.mikerusetsky.livefootball.data.settings.SettingsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object SettingsModule {

    @Singleton
    @Provides
    fun provideSettingsRepository(impl: SettingsRepositoryImpl): SettingsRepository = impl

}