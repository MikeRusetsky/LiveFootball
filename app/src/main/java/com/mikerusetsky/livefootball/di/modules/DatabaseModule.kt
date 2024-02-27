package com.mikerusetsky.livefootball.di.modules

import com.mikerusetsky.livefootball.data.MatchesRepository
import com.mikerusetsky.livefootball.data.MatchesRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideMatchRepository(impl: MatchesRepositoryImpl): MatchesRepository = impl
}