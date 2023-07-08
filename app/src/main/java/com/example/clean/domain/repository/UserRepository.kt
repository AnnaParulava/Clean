package com.example.clean.domain.repository

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.Username

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): Username
}