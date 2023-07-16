package com.example.clean.di

import android.content.Context
import androidx.transition.Visibility.Mode
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import com.example.clean.presentation.ViewModelFactory
import dagger.Module

@Module
class AppModule(val context: Context) {

    fun provideContext(): Context{
        return context
    }

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