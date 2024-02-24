package com.mikerusetsky.livefootball.di

import com.mikerusetsky.livefootball.di.home.HomeComponent
import com.mikerusetsky.livefootball.di.modules.DatabaseModule
import com.mikerusetsky.livefootball.di.modules.DomainModule
import com.mikerusetsky.livefootball.di.modules.RemoteModule
import com.mikerusetsky.livefootball.ui.Home.HomeViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {

    fun getHomeComponent(): HomeComponent

}