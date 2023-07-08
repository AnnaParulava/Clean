package com.example.clean.data.repository

import android.content.Context
import com.example.clean.data.storage.User
import com.example.clean.data.storage.UserStorage
import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.Username
import com.example.clean.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveparam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveparam)
        return userStorage.save(user)
    }

    override fun getName(): Username {
        val user = userStorage.get()
        return mapToDomain(user)
    }
    private fun mapToStorage(saveparam: SaveUserNameParam): User{
        return User(saveparam.name, "")
    }
    private fun mapToDomain(user: User): Username{
        return Username(user.firstName, user.lastName)
    }
}