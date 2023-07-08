package com.example.clean.domain.usecase

import com.example.clean.domain.models.Username
import com.example.clean.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): Username{
        return userRepository.getName()
    }
}