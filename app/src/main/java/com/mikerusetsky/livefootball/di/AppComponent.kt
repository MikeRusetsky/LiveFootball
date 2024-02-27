package com.mikerusetsky.livefootball.di

import com.mikerusetsky.livefootball.di.home.HomeComponent
import com.mikerusetsky.livefootball.di.modules.DatabaseModule
import com.mikerusetsky.livefootball.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun getHomeComponent(): HomeComponent

}