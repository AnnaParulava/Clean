package com.example.clean.di

import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DomainModule::class])
interface AppComponent {
}