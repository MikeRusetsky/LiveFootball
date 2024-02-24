package com.mikerusetsky.livefootball.di.modules

import android.content.Context
import com.mikerusetsky.livefootball.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    fun provideRepository() = MainRepository()
}