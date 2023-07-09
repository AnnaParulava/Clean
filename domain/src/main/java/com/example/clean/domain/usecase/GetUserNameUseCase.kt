package com.example.clean.domain.usecase

import com.example.clean.domain.models.Username
import com.example.clean.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: com.example.clean.domain.repository.UserRepository) {

    fun execute(): com.example.clean.domain.models.Username {

        return userRepository.getName()
    }
}