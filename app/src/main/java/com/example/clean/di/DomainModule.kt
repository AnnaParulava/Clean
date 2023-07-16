package com.example.clean.di

import com.example.clean.domain.repository.UserRepository
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository)
    }
}