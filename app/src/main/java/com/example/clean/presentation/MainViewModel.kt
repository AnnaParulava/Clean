package com.example.clean.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.SharedPrefUserStorage
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import kotlin.math.log

class MainViewModel: ViewModel() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            SharedPrefUserStorage(applicationContext)
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository
        )
    }
    private val saveUserNameParamUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository
        )
    }

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM created")
        super.onCleared()
    }

    fun save(text: String): String{
        val params = com.example.clean.domain.models.SaveUserNameParam(name = text)
        val result = saveUserNameParamUseCase.execute(param = params)
        return "Save result = $result"
    }

    fun load(): String{
        val userName: com.example.clean.domain.models.Username = getUserNameUseCase.execute()
        return "${userName.firstName} ${userName.lastName}"
    }
}