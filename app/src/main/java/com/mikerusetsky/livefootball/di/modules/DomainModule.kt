package com.mikerusetsky.livefootball.di.modules

import android.content.Context
import com.mikerusetsky.livefootball.TmdbApi
import com.mikerusetsky.livefootball.data.MainRepository
import com.mikerusetsky.livefootball.data.PreferenceProvider
import com.mikerusetsky.livefootball.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DomainModule (val context: Context) {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) =
        Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}