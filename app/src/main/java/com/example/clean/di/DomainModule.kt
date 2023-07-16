package com.example.clean.di

import com.example.clean.domain.repository.UserRepository
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import dagger.Module

@Module
class DomainModule {
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository)
    }

    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository)
    }
}