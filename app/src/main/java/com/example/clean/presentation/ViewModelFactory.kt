package com.example.clean.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase

class ViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase,
            saveUserNameUseCase
        ) as T
    }
}