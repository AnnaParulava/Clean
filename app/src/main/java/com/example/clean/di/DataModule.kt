package com.example.clean.di

import android.content.Context
import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.SharedPrefUserStorage
import com.example.clean.data.storage.UserStorage
import com.example.clean.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage{
        return SharedPrefUserStorage(context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository{
        return UserRepositoryImpl(userStorage)
    }
}