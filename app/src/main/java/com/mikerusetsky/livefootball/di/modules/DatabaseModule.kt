package com.mikerusetsky.livefootball.di.modules

import android.content.Context
import com.mikerusetsky.livefootball.data.MainRepository
import dagger.Provides
import javax.inject.Singleton

class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}