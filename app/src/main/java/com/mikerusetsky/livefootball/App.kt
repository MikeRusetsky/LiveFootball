package com.mikerusetsky.livefootball

import android.app.Application
import com.mikerusetsky.livefootball.di.AppComponent
import com.mikerusetsky.livefootball.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}