package com.example.clean.domain.usecase

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: com.example.clean.domain.repository.UserRepository) {
    fun execute(param: com.example.clean.domain.models.SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        return if (oldUserName.firstName == param.name) true
        else userRepository.saveName(param)
    }
}