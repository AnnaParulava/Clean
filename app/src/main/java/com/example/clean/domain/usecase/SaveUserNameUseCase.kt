package com.example.clean.domain.usecase

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam) : Boolean{
        return param.name.isNotEmpty()
    }
}