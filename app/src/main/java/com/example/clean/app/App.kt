package com.example.clean.app

import android.app.Application
import com.example.clean.di.AppComponent
import com.example.clean.di.AppModule
import com.example.clean.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}