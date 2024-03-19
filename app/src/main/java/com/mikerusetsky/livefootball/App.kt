package com.mikerusetsky.livefootball

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.mikerusetsky.livefootball.di.AppComponent
import com.mikerusetsky.livefootball.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    fun switchTheme(darkThemeEnabled: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (darkThemeEnabled) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
        )
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}