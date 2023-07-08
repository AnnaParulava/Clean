package com.example.clean.data.storage

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.Username

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}