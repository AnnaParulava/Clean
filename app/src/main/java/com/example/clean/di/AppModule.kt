package com.example.clean.di

import android.content.Context
import androidx.transition.Visibility.Mode
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import com.example.clean.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }

    @Provides
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