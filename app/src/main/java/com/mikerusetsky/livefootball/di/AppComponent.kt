package com.mikerusetsky.livefootball.di

import android.content.Context
import com.mikerusetsky.livefootball.MainActivity
import com.mikerusetsky.livefootball.di.home.HomeComponent
import com.mikerusetsky.livefootball.di.modules.DatabaseModule
import com.mikerusetsky.livefootball.di.modules.NetworkModule
import com.mikerusetsky.livefootball.di.settings.SettingsComponent
import com.mikerusetsky.livefootball.di.settings.SettingsModule
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Factory
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class,
        SettingsModule::class
    ]
)
interface AppComponent {

    fun getHomeComponent(): HomeComponent

    fun settingsComponent(): SettingsComponent

    fun inject(activity: MainActivity)

    @Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}