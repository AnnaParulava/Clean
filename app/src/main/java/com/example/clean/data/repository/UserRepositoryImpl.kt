package com.example.clean.data.repository

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.Username
import com.example.clean.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override fun saveName(saveparam: SaveUserNameParam): Boolean{
        return true
    }

    override fun getName(): Username{
        return Username(firstName = "Kiparo", lastName = "Hello from repository")
    }
}