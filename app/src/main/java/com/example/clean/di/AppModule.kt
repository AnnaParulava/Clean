package com.example.clean.di

import androidx.transition.Visibility.Mode
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import com.example.clean.presentation.ViewModelFactory
import dagger.Module

@Module
class AppModule {
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): ViewModelFactory{
        return ViewModelFactory(
            getUserNameUseCase,
            saveUserNameUseCase
        )
    }
}