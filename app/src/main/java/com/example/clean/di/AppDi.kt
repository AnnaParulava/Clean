package com.example.clean.di

import com.example.clean.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>{
       MainViewModel(
           getUserNameUseCase = get(),
           saveUserNameParamUseCase = get()
       )
    }
}