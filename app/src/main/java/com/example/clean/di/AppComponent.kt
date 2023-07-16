package com.example.clean.di

import com.example.clean.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}